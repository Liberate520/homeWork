package family_tree.view;

import java.time.LocalDate;
import java.util.Scanner;

import family_tree.model.humans.Gender;
import family_tree.presenter.Presenter;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private boolean procces;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        procces = true;
        menu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void begin() {
        System.out.println("Доброго времени суток!");
        while (procces) {
            System.out.println(menu.menu());
            String request = scanner.nextLine();
            int choice = Integer.parseInt(request);
            menu.execute(choice);
        }
    }

    public void addHuman() {
        System.out.println("Введите имя человека:");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения человека в формате ГГГГ-ММ-ДД:");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        System.out.println("Введите гендер человека (MALE или FEMALE):");
        String genderStr = scanner.nextLine();
        Gender gender = Gender.valueOf(genderStr.toUpperCase());
        presenter.addHuman(name, birthDate, gender);

        System.out.println("Человек успешно добавлен в семейное дерево.");
    }

    public void sortByYear() {
        presenter.sortByYear();
    }

    public void getWomenInfo() {
        presenter.getWomenInfo();
        }

    public void getMenInfo(){
        presenter.getMenInfo();
    }   
    public void getHumansInfo(){
        presenter.getHumansInfo();
    }
    
    public void end(){
        System.out.println("Всего хорошего!");
        procces = false;
    }
    }

