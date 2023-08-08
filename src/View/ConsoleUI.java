package View;

import Model.Human.Gender;
import Model.Human.Status;
import Presenter.Presenter;
import View.tests.Test;
import View.tests.TestForUI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private final Presenter presenter;
    private final Scanner scanner;
    private boolean flag;
    private final MainMenu menu;
    private final Test tests;
    private final TextInput textInput;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        flag = true;
        menu = new MainMenu(this);
        textInput = new TextInput();
        tests = new TestForUI(this, menu, textInput);
    }

    @Override
    public void start() {
        while (flag) {
            execution();
        }
    }

    private void execution() {
        System.out.println(menu.menu());
        printAnswer(textInput.getAnswer("choice"));
        String string = scanner.nextLine();
        String choice = tests.menuTest(string);
        if (choice != null) {
            int choiceInt = Integer.parseInt(choice);
            menu.execute(choiceInt);
        }
    }

    public void exit() {
        printAnswer(textInput.getAnswer("farewell"));
        flag = false;
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
        printAnswer(textInput.getAnswer("setName"));
        String name = setName();
        printAnswer(textInput.getAnswer("setDate"));
        LocalDate date = setDate();
        printAnswer(textInput.getAnswer("setGender"));
        Gender gender = setGender();
        printAnswer(textInput.getAnswer("setStatus"));
        Status status = setStatus();
        LocalDate deathDate = null;
        if (status.equals(Status.dead)) {
            printAnswer(textInput.getAnswer("setName"));
            deathDate = setDate();
        }
        presenter.addHuman(name, date, gender, status, deathDate);
    }

    @Override
    public Gender setGender() {
        Gender gender;
        String gen = scanner.nextLine().toLowerCase();
        List<String> genList = List.of(Gender.female.toString(), Gender.male.toString());
        if (genList.contains(gen)) {
            gender = Gender.valueOf(gen);
        } else {
            boolean flag = true;
            while (flag) {
                printAnswer(textInput.getAnswer("errorSetAgain"));
                gen = scanner.nextLine().toLowerCase();
                if (genList.contains(gen)) {
                    flag = false;
                }
            }
            gender = Gender.valueOf(gen);
        }
        return gender;
    }

    @Override
    public Status setStatus() {
        Status status;
        String stat = scanner.nextLine().toLowerCase();
        List<String> statList = List.of(Status.dead.toString(), Status.alive.toString());
        if (!statList.contains(stat)) {
            boolean flag = true;
            while (flag) {
                printAnswer(textInput.getAnswer("errorSetAgain"));
                stat = scanner.nextLine().toLowerCase();
                if (statList.contains(stat)) {
                    flag = false;
                }
            }
        }
        status = Status.valueOf(stat);
        return status;
    }

    @Override
    public LocalDate setDate() {
        printAnswer(textInput.getAnswer("setYear"));
        String yearStr = scanner.nextLine();
        int year = tests.testYear(yearStr);

        printAnswer(textInput.getAnswer("setMonth"));
        String monthStr = scanner.nextLine();
        int month = tests.testMonth(monthStr);

        printAnswer(textInput.getAnswer("setDay"));
        String dayStr = scanner.nextLine();
        int day = tests.testDay(dayStr);

        return LocalDate.of(year, month, day);
    }

    @Override
    public String setName() {
        return scanner.nextLine();
    }

    @Override
    public void findById() {
        printAnswer(textInput.getAnswer("setId"));
        String count = scanner.nextLine();
        if (tests.testInt(count)) {
            int countInt = Integer.parseInt(count);
            presenter.findById(countInt);
        } else {
            printAnswer(textInput.getAnswer("error"));
        }
    }

    @Override
    public void addHumanWithParents() {
        printAnswer(textInput.getAnswer("setName"));
        String name = setName();
        printAnswer(textInput.getAnswer("setDate"));
        LocalDate date = setDate();
        printAnswer(textInput.getAnswer("setGender"));
        Gender gender = setGender();
        printAnswer(textInput.getAnswer("setStatus"));
        Status status = setStatus();
        LocalDate deathDate = null;
        if (status.equals(Status.dead)) {
            deathDate = setDate();
        }
        printAnswer(textInput.getAnswer("setMotherId"));
        String idMotherStr = scanner.nextLine();
        tests.testInt(idMotherStr);
        int idMother = Integer.parseInt(idMotherStr);
        printAnswer(textInput.getAnswer("setFatherId"));
        String idFatherStr = scanner.nextLine();
        tests.testInt(idFatherStr);
        int idFather = Integer.parseInt(idMotherStr);
        presenter.addHumanWithParents(name, date, gender, status, idFather, idMother, deathDate);
    }

    @Override
    public void makeMarriage() {
        printAnswer(textInput.getAnswer("setFirstSpouseId"));
        String spouseOneIdStr = scanner.nextLine();
        tests.testInt(spouseOneIdStr);
        int spouseOneId = Integer.parseInt(spouseOneIdStr);
        printAnswer(textInput.getAnswer("setSecondSpouseId"));
        String spouseTwoIdStr = scanner.nextLine();
        tests.testInt(spouseOneIdStr);
        int spouseTwoId = Integer.parseInt(spouseTwoIdStr);
        presenter.makeMarriage(spouseOneId, spouseTwoId);
    }

    @Override
    public void save() {
        presenter.saveInfo();
    }

    @Override
    public void load() {
        presenter.loadInfo();
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void addChild() {
        printAnswer(textInput.getAnswer("setChildId"));
        String childIdStr = scanner.nextLine();
        while (!(tests.testInt(childIdStr))) {
            childIdStr = scanner.nextLine();
        }
        int childId = Integer.parseInt(childIdStr);

        printAnswer(textInput.getAnswer("setParentsId"));
        printAnswer(textInput.getAnswer("setMotherId"));
        String motherIdStr = scanner.nextLine();
        while (!(tests.testInt(motherIdStr))) {
            motherIdStr = scanner.nextLine();
        }
        int motherId = Integer.parseInt(motherIdStr);

        printAnswer(textInput.getAnswer("setFatherId"));
        String fatherIdStr = scanner.nextLine();
        while (!(tests.testInt(fatherIdStr))) {
            fatherIdStr = scanner.nextLine();
        }
        int fatherId = Integer.parseInt(fatherIdStr);

        presenter.addChild(childId, motherId, fatherId);
    }
}
