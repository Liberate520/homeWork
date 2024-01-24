package ru.gb.view;

import ru.gb.model.treeItem.Gender;
import ru.gb.presenter.PresenterForPeople;
import ru.gb.view.gender.GenderMenu;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private PresenterForPeople presenter;
    private boolean flag;
    private GenderMenu genderMenu;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new PresenterForPeople(this);
        flag = true;
        genderMenu = new GenderMenu(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Добро пожаловать в семью!");

        while (flag) {
            printMenu();
            choice();
        }
    }

    private void choice() throws IOException, ClassNotFoundException {
        String choiceStr = scanner.nextLine();
        if (choiceStr.matches("\\d+") && Integer.parseInt(choiceStr) <= menu.size() && Integer.parseInt(choiceStr) > 0) {
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        } else {
            System.out.println("Введите валидное число");
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void addTreeItem() {
        System.out.println("Введите имя члена семьи");
        String name = scanner.nextLine();

        System.out.println("Введите номер гендера");
        printGenderMenu();
        Gender gender = genderMenu.execute(Integer.parseInt(scanner.nextLine()));

        LocalDate birthDate = getBirthDate();

        System.out.println("Введите индекс семейного древа, в которое хотите добавить члена семьи");
        int treeIndex = Integer.parseInt(scanner.nextLine());

        presenter.addItemToFamilyTree(name, gender, birthDate, treeIndex);
    }

    public LocalDate getDeathDate() {
        System.out.println("Введите год смерти:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц смерти:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день смерти:");
        int day = Integer.parseInt(scanner.nextLine());
        return LocalDate.of(year, month, day);
    }

    public void setDeathDate() {
        System.out.println("Введите имя нужного человека");
        String name = scanner.nextLine();
        System.out.println("Введите индекс древа в котором находится человек");
        int treeIndex = Integer.parseInt(scanner.nextLine());
        LocalDate deathDate = getDeathDate();

        presenter.setDeathDate(name, treeIndex, deathDate);
    }

    public LocalDate getBirthDate() {
        System.out.println("Введите год рождения:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц рождения:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день рождения:");
        int day = Integer.parseInt(scanner.nextLine());
        return LocalDate.of(year, month, day);
    }

    public void printGenderMenu() {
        System.out.println(genderMenu.menu());
    }

    public Gender strToGender(String gender) {
        return presenter.strToGender(gender);
    }

    public void createEmptyTree() {
        presenter.createNewFamilyTree();
    }

    public void getInfoByName() {
        System.out.println("Введите имя нужного человека");
        String name = scanner.nextLine();
        System.out.println("Введите индекс древа в котором находится человек");
        int treeIndex = Integer.parseInt(scanner.nextLine());

        System.out.println(presenter.getInfoByName(name, treeIndex));
    }

    public void getAllTreesInfo() {
        presenter.getAllTreesInfo();
    }

    public void saveTrees() throws IOException, ClassNotFoundException {
        presenter.saveTrees();
    }

    public void loadTrees() throws IOException, ClassNotFoundException {
        presenter.loadAllTrees();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void addMom() {
        System.out.println("Введите имя мамы");
        String momName = scanner.nextLine();
        System.out.println("Введите имя ребенка");
        String childName = scanner.nextLine();
        System.out.println("Введите индекс древа в котором они находятся");
        int treeIndex = Integer.parseInt(scanner.nextLine());

        presenter.addMom(momName, childName, treeIndex);
    }

    public void addDad() {
        System.out.println("Введите имя папы");
        String dadName = scanner.nextLine();
        System.out.println("Введите имя ребенка");
        String childName = scanner.nextLine();
        System.out.println("Введите индекс древа в котором они находятся");
        int treeIndex = Integer.parseInt(scanner.nextLine());

        presenter.addDad(dadName, childName, treeIndex);
    }

    public void addChild() {
        System.out.println("Введите имя родителя");
        String parentName = scanner.nextLine();
        System.out.println("Введите имя ребенка");
        String childName = scanner.nextLine();
        System.out.println("Введите индекс древа в котором они находятся");
        int treeIndex = Integer.parseInt(scanner.nextLine());

        presenter.addChild(parentName, childName, treeIndex);
    }

    public void finish() {
        System.out.println("Завершение работы...");
        flag = false;
    }
}
