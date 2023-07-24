package ui;

import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleView implements View {

    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;
    private VerificationInt translationIntoInteger;

    public ConsoleView() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
        translationIntoInteger = new VerificationInt();
    }

    @Override
    public void start() {
        System.out.println("Здравствуйте");
        while (work) {
            System.out.println(menu.menu());
            String line = scanner.nextLine();
            int lineInt = translationIntoInteger.verificationInt(line, menu.getSize()); 
            menu.execute(lineInt);
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void creatHuman() {
        System.out.println("ВВедите имя: ");
        String firstName = scanner.nextLine();
        System.out.println("ВВедите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("ВВедите отчество: ");
        String middleName = scanner.nextLine();

        System.out.println("Введите день рождения: ");
        String day = scanner.nextLine();
        int dayInt = translationIntoInteger.verificationInt(day, 31);
        System.out.println("Введите месяц рождения: ");
        String month = scanner.nextLine();
        int monthInt = translationIntoInteger.verificationInt(month, 12);
        System.out.println("Введите год рождения: ");
        String year = scanner.nextLine();
        int yearInt = translationIntoInteger.verificationInt(year, 3000);
        LocalDate born = LocalDate.of(yearInt, monthInt, dayInt);

        System.out.println("жив человек(y - да n - нет): ");
        String isLive = scanner.nextLine();
        LocalDate death;
        if (isLive.equals("Y") || isLive.equals("y")) {
            death = null;
        } else {
            System.out.println("Введите день смерти: ");
            String dayDeath = scanner.nextLine();
            int dayDeathInt = translationIntoInteger.verificationInt(dayDeath, 31);
            System.out.println("Введите месяц смерти: ");
            String monthDeath = scanner.nextLine();
            int monthDeathInt = translationIntoInteger.verificationInt(monthDeath, 12);
            System.out.println("Введите год смерти: ");
            String yearDeath = scanner.nextLine();
            int yearDeathInt = translationIntoInteger.verificationInt(yearDeath, 3000);
            death = LocalDate.of(dayDeathInt, monthDeathInt, yearDeathInt);
        }

        System.out.println("Введите пол человека: ");
        String gender = scanner.nextLine();
        presenter.creatHuman(firstName, lastName, middleName, born, death, gender);
    }



    public void addChild() {

        System.out.println("Выберите ребенка(напишите число): ");
        presenter.getHumanList();
        String childHuman = scanner.nextLine();
        int childHumanInt = translationIntoInteger.verificationInt(childHuman, presenter.getSizeListHuman());

        System.out.println("Выберите родителя: ");
        presenter.getHumanList();
        String parentHuman = scanner.nextLine();
        int parentHumanInt = translationIntoInteger.verificationInt(parentHuman, presenter.getSizeListHuman());
        presenter.addChild(childHumanInt, parentHumanInt);

    }

    public void searchName() {
        System.out.println("Введите имя человека которого хотите найти: ");
        String nameSearch = scanner.nextLine();
        presenter.searchName(nameSearch);
    }

    public void getHumanList() {
        presenter.getHumanList();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void saveFile() {
        System.out.println("Введите имя файла для сохранения дерева :");
        String fileName = scanner.nextLine();
        presenter.saveFile(fileName);
    }

    public void loadFile() {
        System.out.println("Введите имя файла для считывания :");
        String fileName = scanner.nextLine();
        presenter.loadFile(fileName);
    }

    public void finish() {
        System.out.println("Спасибо за использование дерева. \n Спасибо за использование.");
        work = false;
    }
}
