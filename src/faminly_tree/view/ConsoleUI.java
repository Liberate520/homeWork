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
    private String pathRemember;

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
            System.out.println();
            System.out.println(menu.getMenu());
            int choice = takeChoice();
            if (choice != -1) menu.execute(choice);
            else System.out.printf("Некорректно введена команда. Введите число от 1 до %d\n", menu.getSize());
        }
    }
    private void Hello() {
        print("Приветствую! Выберите действие:\n" +
                "1. Начать новый проект\n" +
                "2. Открыть проект");
        String answer = scanner.nextLine();
        int choice = examination(answer);
        if (choice == -1) System.out.printf("Некорректно введена команда. Введите число 1 или 2");
        if (choice == 2) {
            print("Укажите имя файла:");
            String name = scanner.nextLine();
            if (!name.contains(".out")) name = name + ".out";
            this.pathRemember = name;
            downland(name);
        }
     }
    public void downland(String path){
        presenter.downland(path);
    }
    private int takeChoice() {
        String line = scanner.nextLine();
        int choice =  examination(line);
        int size = menu.getSize();
        if ((choice > size) || (choice <= 0)) return -1;
        return choice;
    }
    private int examination(String line){
        try {
            return Integer.parseInt(line);
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }
    public void addHuman() {
        Gender gender = null;
        boolean flag = false;
        print("Введите имя человека");
        String name = scanner.nextLine();
        print("Укажете пол человека (ж, м):");
        String sex = scanner.nextLine().toLowerCase();
        print("Укажите дату рождения (год/месяц/день):");
        String birth = scanner.nextLine();

        if (sex.contains("м")) gender = Gender.Male;
        else if (sex.contains("ж")) gender = Gender.Female;
        else {
            print("Некорректно указан пол");
            flag = true;
        }
        String[] birthDate = birth.split("/");
        int birthYear = 0, birthMonth = 0, birthDay = 0;
        if (birthDate.length != 3) {
            print("Некорректно указана дата рождения");
            flag = true;
        } else {
            birthYear = Integer.parseInt(birthDate[0]);
            birthMonth = Integer.parseInt(birthDate[1]);
            birthDay = Integer.parseInt(birthDate[2]);
            if (birthYear <= 0 || (birthMonth <= 0 || birthMonth > 12) || (birthDay <= 0 || birthDay > 31)) {
                print("Некорректно указана дата рождения");
                flag = true;
            }
        }
        if (flag == false) {
            LocalDate date = LocalDate.of(birthYear, birthMonth, birthDay);
            presenter.addHuman(name, gender, date);
            print("Успешно!");
        }
    }
    public void addConnection() {
        if (presenter.treeIsEmpty() == 0) {
            print("Дерево не заполнено");
            return;
        }
        print("Укажите id родителя, имеющегося в древе, для которого вы хотите установить родственную связь: ");
        int parentID = findHumanID();
        if (parentID == -1) {
            print("Ошибка ввода числа");
            return;
        }
        print("Укажите id ребенка, имеющегося в древе, для которого вы хотите установить родственную связь: ");
        int childID = findHumanID();
        if (childID == -1) {
            print("Ошибка ввода числа");
            return;
        }
        boolean flag = presenter.connection(parentID, childID);
        if (flag == false) print("Человека с таким id нет в семейном древе");
        else print("Успешно изменена родственная связь");
    }
    public void showAllTree() {
        presenter.showAllTree();
    }
    public void sortByAge() {
        if (presenter.treeIsEmpty() == 0) {
            print("Дерево не заполнено");
            return;
        }
        presenter.sortByAge();
    }
    public void sortByID(){
        presenter.sortByID();
    }
    public void sortByName() {
        if (presenter.treeIsEmpty() == 0) {
            print("Дерево не заполнено");
            return;
        }
        presenter.sortByName();
    }
    public void finish() {
        print("Вы хотите сохранить работу над проектом?");
        String answer = scanner.nextLine();
        if (answer.equals("да") || answer.equals("yes")) {
            if (pathRemember != null){
                if (!save(pathRemember)) print("К сожалению, не получилось сохранить файл!");
                else print("Успешно сохранили вашу работу!");
            }
            else {
                print("Введите имя файла на английском: ");
                String name = scanner.nextLine().toLowerCase();
                name = name + ".out";
                if (!save(name)) print("К сожалению, не получилось сохранить файл!");
                else print("Успешно сохранили вашу работу!");
            }
        }
        System.out.println("До свидания!");
        work = false;
    }
    public boolean save(String name){
        return presenter.save(name);
    }
    private int findHumanID() {
        showAllTree();
        String id = scanner.nextLine();
        return examination(id);
    }
    public void nextOfKin() {
        if (presenter.treeIsEmpty() == 0) {
            print("Дерево не заполнено");
            return;
        }
        print("Укажите id родителя, имеющегося в древе, для которого вы хотите установить родственную связь: ");
        int humanID = findHumanID();
        if (humanID == -1) {
            print("Ошибка ввода числа");
            return;
        }
        presenter.nextOfKin(humanID);
    }
    public void returnToFirstMenu() {
        Hello();
    }
}
