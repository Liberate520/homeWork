package View;

import Model.Human.Gender;
import Model.Human.Status;
import Presenter.Presenter;
import View.tests.TestForUI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag;
    private MainMenu menu;
    private TestForUI tests;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        flag = true;
        menu = new MainMenu(this);
        tests = new TestForUI(this, menu);
    }

    @Override
    public void start() {
        while (flag) {
            execution();
        }
    }

    private void execution() {
        System.out.println(menu.menu());
        System.out.println("Выберите действие: ");
        String string = scanner.nextLine();
        String choice = tests.menuTest(string);
        if (choice != null) {
            int choiceInt = Integer.parseInt(choice);
            menu.execute(choiceInt);
        }
    }

    public void exit() {
        System.out.println("Досвидания!");
        flag = false;
    }

    @Override
    public String error() {
        return "Неправильный ввод значения.";
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void getInfo() {
        presenter.getInfo();
    }

    public void addHuman() {
        System.out.println("Укажите имя человека: ");
        String name = setName();
        System.out.println("Укажите дату рождения: ");
        LocalDate date = setDate();
        System.out.println("Укажите пол человека: ");
        Gender gender = setGender();
        System.out.println("Укажите статус человека");
        Status status = setStatus();
        LocalDate deathDate = null;
        if (status.equals(Status.dead)) {
            deathDate = setDate();
        }
        presenter.addHuman(name, date, gender, status, deathDate);
    }

    private Gender setGender() {
        Gender gender;
        String gen = scanner.nextLine().toLowerCase();
        List<String> genList = List.of(Gender.female.toString(), Gender.male.toString());
        if (genList.contains(gen)) {
            gender = Gender.valueOf(gen);
        } else {
            boolean flag = true;
            while (flag) {
                System.out.println("Неверно, укажите заново");
                gen = scanner.nextLine().toLowerCase();
                if (genList.contains(gen)) {
                    flag = false;
                }
            }
            gender = Gender.valueOf(gen);
        }
        return gender;
    }

    private Status setStatus() {
        Status status;
        String stat = scanner.nextLine().toLowerCase();
        List<String> statList = List.of(Status.dead.toString(), Status.alive.toString());
        if (statList.contains(stat)) {
            status = Status.valueOf(stat);
        } else {
            boolean flag = true;
            while (flag) {
                System.out.println("Неверно, укажите заново");
                stat = scanner.nextLine().toLowerCase();
                if (statList.contains(stat)) {
                    flag = false;
                }
            }
            status = Status.valueOf(stat);
        }
        return status;
    }

    public LocalDate setDate() {
        System.out.println("Укажите год: ");
        String yearStr = scanner.nextLine();
        int year = tests.testYear(yearStr);
        System.out.println("Укажите месяц: ");
        String monthStr = scanner.nextLine();
        int month = tests.testMonth(monthStr);
        System.out.println("Укажите день: ");

        String dayStr = scanner.nextLine();
        int day = tests.testDay(dayStr);
        return LocalDate.of(year, month, day);
    }

    private String setName() {
        return scanner.nextLine();
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void findById() {
        System.out.println("Введите id человека: ");
        String count = scanner.nextLine();
        if (tests.testInt(count)) {
            int countInt = Integer.parseInt(count);
            presenter.findById(countInt);
        } else {
            printAnswer(error());
        }
    }

    public void addHumanWithParents() {
        System.out.println("Укажите имя человека: ");
        String name = setName();
        System.out.println("Укажите дату рождения: ");
        LocalDate date = setDate();
        System.out.println("Укажите пол человека: ");
        Gender gender = setGender();
        System.out.println("Укажите статус человека");
        Status status = setStatus();
        LocalDate deathDate = null;
        if (status.equals(Status.dead)) {
            deathDate = setDate();
        }
        System.out.println("Укажите id матери: ");
        String idMotherStr = scanner.nextLine();
        tests.testInt(idMotherStr);
        int idMother = Integer.parseInt(idMotherStr);
        System.out.println("Укажите id отца: ");
        String idFatherStr = scanner.nextLine();
        tests.testInt(idFatherStr);
        int idFather = Integer.parseInt(idMotherStr);
        presenter.addHumanWithParents(name, date, gender, status, idFather, idMother, deathDate);
    }

    public void makeMarriage() {
        System.out.println("Укажите id первого партнёра: ");
        String spouseOneIdStr = scanner.nextLine();
        tests.testInt(spouseOneIdStr);
        int spouseOneId = Integer.parseInt(spouseOneIdStr);
        System.out.println("Укажите id второго партнёра: ");
        String spouseTwoIdStr = scanner.nextLine();
        tests.testInt(spouseOneIdStr);
        int spouseTwoId = Integer.parseInt(spouseTwoIdStr);
        presenter.makeMarriage(spouseOneId, spouseTwoId);
    }

    public void addChild() {
        presenter.addChild();
    }

    public void save() {
        presenter.saveInfo();
    }

    public void load() {
        presenter.loadInfo();
    }
}
