package ru.gb.view;

import ru.gb.general_methods.IsValidNumber;
import ru.gb.general_methods.IsValidTreeNum;
import ru.gb.model.person.Person;
import ru.gb.model.treeItem.Gender;
import ru.gb.presenter.PresenterForPeople;
import ru.gb.view.gender.GenderMenu;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

public class ConsoleUI implements View {
    private IsValidNumber numberValidChecker;
    private Scanner scanner;
    private PresenterForPeople presenter;
    private boolean flag;
    private GenderMenu genderMenu;
    private IsValidTreeNum treeNumChecker;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new PresenterForPeople(this);
        flag = true;
        genderMenu = new GenderMenu(this);
        menu = new MainMenu(this);
        numberValidChecker = new IsValidNumber();
        treeNumChecker = new IsValidTreeNum(presenter.getAmountOfTrees());
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
        if (numberValidChecker.isValidInRange(1, menu.size() + 1, choiceStr)) {
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        } else {
            numberValidChecker.error();
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
        String userResponse = scanner.nextLine();
        if (numberValidChecker.isValidInRange(1, genderMenu.size(), userResponse)) {
            Gender gender = genderMenu.execute(Integer.parseInt(userResponse));
            LocalDate birthDate = getBirthDate();

            int treeIndex = getTreeIndexConsole();

            if (treeNumChecker.isValidTreeNum(treeIndex)) {
                presenter.addItemToFamilyTree(name, gender, birthDate, treeIndex);
            } else {
                treeNumChecker.error();
            }
        } else {
            System.out.println("Неверный номер гендера");
        }
    }

    public LocalDate getDeathDate() {
        System.out.println("Введите год смерти:");
        String strYear = scanner.nextLine();
        while (!numberValidChecker.isValidInRange(0, Year.now().getValue(), strYear)) {
            numberValidChecker.error();
            System.out.println("Введите год смерти:");
            strYear = scanner.nextLine();
        }
        int year = Integer.parseInt(strYear);

        System.out.println("Введите месяц смерти:");
        String strMonth = scanner.nextLine();
        while (!numberValidChecker.isValidInRange(1, 12, strMonth)) {
            numberValidChecker.error();
            System.out.println("Введите месяц смерти:");
            strMonth = scanner.nextLine();
        }
        int month = Integer.parseInt(strMonth);

        System.out.println("Введите день смерти:");
        String strDay = scanner.nextLine();
        while (!numberValidChecker.isValidInRange(1, 31, strDay)) {
            numberValidChecker.error();
            System.out.println("Введите день смерти:");
            strDay = scanner.nextLine();
        }
        int day = Integer.parseInt(strDay);

        return LocalDate.of(year, month, day);
    }

    public void setDeathDate() {
        System.out.println("Введите имя нужного человека");
        String name = scanner.nextLine();
        int treeIndex = getTreeIndexConsole();
        LocalDate deathDate = getDeathDate();

        if (treeNumChecker.isValidTreeNum(treeIndex)) {
            presenter.setDeathDate(name, treeIndex, deathDate);
        } else {
            treeNumChecker.error();
        }
    }

    public LocalDate getBirthDate() {
        System.out.println("Введите год рождения:");
        String strYear = scanner.nextLine();
        while (!numberValidChecker.isValidInRange(0, Year.now().getValue(), strYear)) {
            numberValidChecker.error();
            System.out.println("Введите год рождения:");
            strYear = scanner.nextLine();
        }
        int year = Integer.parseInt(strYear);

        System.out.println("Введите месяц рождения:");
        String strMonth = scanner.nextLine();
        while (!numberValidChecker.isValidInRange(1, 12, strMonth)) {
            numberValidChecker.error();
            System.out.println("Введите месяц рождения:");
            strMonth = scanner.nextLine();
        }
        int month = Integer.parseInt(strMonth);

        System.out.println("Введите день рождения:");
        String strDay = scanner.nextLine();
        while (!numberValidChecker.isValidInRange(1, 31, strDay)) {
            numberValidChecker.error();
            System.out.println("Введите день рождения:");
            strDay = scanner.nextLine();
        }
        int day = Integer.parseInt(strDay);

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
        int treeIndex = getTreeIndexConsole();

        if (treeNumChecker.isValidTreeNum(treeIndex)) {
            Person person = presenter.getInfoByName(name, treeIndex);
            if (person == null) {
                System.out.println("Члена семьи не найдено");
            } else {
                System.out.println("-----------------------");
                System.out.println(person);
                System.out.println("-----------------------");
            }
        } else {
            treeNumChecker.error();
        }
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
        int treeIndex = getTreeIndexConsole();

        if (treeNumChecker.isValidTreeNum(treeIndex)) {
            presenter.addMom(momName, childName, treeIndex);
        } else {
            treeNumChecker.error();
        }
    }

    public void addDad() {
        System.out.println("Введите имя папы");
        String dadName = scanner.nextLine();
        System.out.println("Введите имя ребенка");
        String childName = scanner.nextLine();
        int treeIndex = getTreeIndexConsole();

        if (treeNumChecker.isValidTreeNum(treeIndex)) {
            presenter.addMom(dadName, childName, treeIndex);
        } else {
            treeNumChecker.error();
        }
    }

    public void addChild() {
        System.out.println("Введите имя родителя");
        String parentName = scanner.nextLine();
        System.out.println("Введите имя ребенка");
        String childName = scanner.nextLine();
        int treeIndex = getTreeIndexConsole();

        if (treeNumChecker.isValidTreeNum(treeIndex)) {
            presenter.addMom(parentName, childName, treeIndex);
        } else {
            treeNumChecker.error();
        }
    }

    public void finish() {
        System.out.println("Завершение работы...");
        flag = false;
    }

    private int getTreeIndexConsole() {
        System.out.println("Введите индекс семейного древа");
        String consoleRespond = scanner.nextLine();
        if (numberValidChecker.isNumeric(consoleRespond)) {
            return Integer.parseInt(consoleRespond);
        } else {
            return presenter.getAmountOfTrees() + 1;
        }
    }
}
