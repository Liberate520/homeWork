package faminly_tree.view;

import faminly_tree.model.human.Gender;
import faminly_tree.presenter.Presenter;
import faminly_tree.view.commands.MainMenu;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        Hello();
        while (work) {
            System.out.println(menu.getMenu());
            int choice = takeChoice();
            if (choice != -1) menu.execute(choice);
            else System.out.printf("Некорректно введена команда. Введите число от 1 до %d\n", menu.getSize());
        }
    }

    private void Hello() {
        System.out.println("Приветствую, пользователь!");
    }

    private int takeChoice() {
        String line = scanner.nextLine();
        if (examination(line)) {
            int choice =  Integer.parseInt(line);
            int size = menu.getSize();
            if ((choice > size) || (choice <= 0)) return -1;
            return choice;
        }
        else return -1;
    }
    private boolean examination(String line){
        try {
            Integer.parseInt(line);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    public void addHuman() {
        Gender gender = null;
        boolean flag = false;
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажете пол человека (ж, м):");
        String sex = scanner.nextLine().toLowerCase();
        System.out.println("Укажите дату рождения (год/месяц/день):");
        String birth = scanner.nextLine();

        if (sex.contains("м")) gender = Gender.Male;
        else if (sex.contains("ж")) gender = Gender.Female;
        else {
            System.out.println("Некорректно указан пол");
            flag = true;
        }
        String[] birthDate = birth.split("/");
        int birthYear = 0, birthMonth = 0, birthDay = 0;
        if (birthDate.length != 3) {
            System.out.println("Некорректно указана дата рождения");
            flag = true;
        } else {
            birthYear = Integer.parseInt(birthDate[0]);
            birthMonth = Integer.parseInt(birthDate[1]);
            birthDay = Integer.parseInt(birthDate[2]);
            if (birthYear <= 0 || (birthMonth <= 0 || birthMonth > 12) || (birthDay <= 0 || birthDay > 31)) {
                System.out.println("Некорректно указана дата рождения");
                flag = true;
            }
        }
        if (flag == false) {
            LocalDate date = LocalDate.of(birthYear, birthMonth, birthDay);
            presenter.addHuman(name, gender, date);
        }

    }

    public void addConnection() {
        System.out.println("Укажите id родителя, имеющегося в древе, для которого вы хотите установить родственную связь: ");
        int parentID = findHumanID();
        if (parentID == -1) {
            System.out.println("Ошибка ввода числа");
            return;
        }
        System.out.println("Укажите id ребенка, имеющегося в древе, для которого вы хотите установить родственную связь: ");
        int childID = findHumanID();
        if (childID == -1) {
            System.out.println("Ошибка ввода числа");
            return;
        }
        boolean flag = presenter.connection(parentID, childID);
        if (flag == false) System.out.println("Человека с таким id нет в семейном древе");
        else System.out.println("Успешно изменена родственная связь");
    }

    public void showAllTree() {
        presenter.showAllTree();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void finish() {
        System.out.println("До свидания");
        work = false;
    }

    private int findHumanID() {
        showAllTree();
        String id = scanner.nextLine();
        if (examination(id)) {

            return Integer.parseInt(id);
        }
        else return -1;
    }
}
