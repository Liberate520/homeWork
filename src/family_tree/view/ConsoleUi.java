package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUi implements View{

    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;

    public ConsoleUi() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);


    }

    @Override
    public void start() {
        System.out.println("Привет!");
        while (work) {
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            if(validChoice(choice)) {
                int numChoice = Integer.parseInt(choice);
                menu.execute(numChoice);
            } else {
                System.out.println("Выберите команду из списка");
            }
        }

    }

    private boolean validChoice(String choice) {
        int numChoice;
        int size = menu.getSize();
        if(choice == null || choice.equals("")) {
            System.out.println("Вы не ввели команду");
            return false;
        }
        try {
            numChoice = Integer.parseInt(choice);
            return size >= numChoice && numChoice > 0;
        } catch (NumberFormatException e) {
            System.out.println("Нет такой команды");
        }
        return false;
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);

    }

    public void finish() {
        System.out.println("Работа завершена, спасибо! ");
        work = false;
    }

    public void sortByBirthDate(){
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getInfo() {
        presenter.getInfo();
    }
    public void read() { presenter.read();}
    public void save() {
        presenter.save();
        System.out.println("Данные сохранены");
        System.out.println("\n");
    }

    public void addHuman() {
            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            System.out.println("Введите пол Male или Female: ");
            String gend = scanner.nextLine();
            Gender gender = Gender.valueOf(gend);
            System.out.println("Введите дату рождения в формате гггг-мм-дд: ");
            String date = scanner.nextLine();
            LocalDate birthDate = LocalDate.parse(date);
            System.out.println("Введите имя отца: ");
            String nameFather = scanner.nextLine();
            System.out.println("Введите имя матери: ");
            String nameMother = scanner.nextLine();
            presenter.addHuman(name, gender, birthDate, nameFather, nameMother);

        }

    }

