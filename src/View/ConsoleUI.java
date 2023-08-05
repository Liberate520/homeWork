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
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag;
    private MainMenu menu;
    private Test tests;
    private TextInput textInput;

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
        textInput.printAnswer("choice");
        String string = scanner.nextLine();
        String choice = tests.menuTest(string);
        if (choice != null) {
            int choiceInt = Integer.parseInt(choice);
            menu.execute(choiceInt);
        }
    }

    public void exit() {
        textInput.printAnswer("farewell");
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
        textInput.printAnswer("setName");
        String name = setName();
        textInput.printAnswer("setDate");
        LocalDate date = setDate();
        textInput.printAnswer("setGender");
        Gender gender = setGender();
        textInput.printAnswer("setStatus");
        Status status = setStatus();
        LocalDate deathDate = null;
        if (status.equals(Status.dead)) {
            textInput.printAnswer("setName");
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
                textInput.printAnswer("errorSetAgain");
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
                textInput.printAnswer("errorSetAgain");
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
        textInput.printAnswer("setYear");
        String yearStr = scanner.nextLine();
        int year = tests.testYear(yearStr);

        textInput.printAnswer("setMonth");
        String monthStr = scanner.nextLine();
        int month = tests.testMonth(monthStr);

        textInput.printAnswer("setDay");
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
        textInput.printAnswer("setId");
        String count = scanner.nextLine();
        if (tests.testInt(count)) {
            int countInt = Integer.parseInt(count);
            presenter.findById(countInt);
        } else {
            textInput.printAnswer("error");
        }
    }

    public void addHumanWithParents() {
        textInput.printAnswer("setName");
        String name = setName();
        textInput.printAnswer("setDate");
        LocalDate date = setDate();
        textInput.printAnswer("setGender");
        Gender gender = setGender();
        textInput.printAnswer("setStatus");
        Status status = setStatus();
        LocalDate deathDate = null;
        if (status.equals(Status.dead)) {
            deathDate = setDate();
        }
        textInput.printAnswer("setMotherId");
        String idMotherStr = scanner.nextLine();
        tests.testInt(idMotherStr);
        int idMother = Integer.parseInt(idMotherStr);
        textInput.printAnswer("setFatherId");
        String idFatherStr = scanner.nextLine();
        tests.testInt(idFatherStr);
        int idFather = Integer.parseInt(idMotherStr);
        presenter.addHumanWithParents(name, date, gender, status, idFather, idMother, deathDate);
    }

    public void makeMarriage() {
        textInput.printAnswer("setFirstSpouseId");
        String spouseOneIdStr = scanner.nextLine();
        tests.testInt(spouseOneIdStr);
        int spouseOneId = Integer.parseInt(spouseOneIdStr);
        textInput.printAnswer("setSecondSpouseId");
        String spouseTwoIdStr = scanner.nextLine();
        tests.testInt(spouseOneIdStr);
        int spouseTwoId = Integer.parseInt(spouseTwoIdStr);
        presenter.makeMarriage(spouseOneId, spouseTwoId);
    }

    public void save() {
        presenter.saveInfo();
    }

    public void load() {
        presenter.loadInfo();
    }

    public void addChild() {
        textInput.printAnswer("setChildId");
        String childIdStr = scanner.nextLine();
        while (!(tests.testInt(childIdStr))) {
            childIdStr = scanner.nextLine();
        }
        int childId = Integer.parseInt(childIdStr);

        textInput.printAnswer("setParentsId");
        textInput.printAnswer("setMotherId");
        String motherIdStr = scanner.nextLine();
        while (!(tests.testInt(motherIdStr))) {
            motherIdStr = scanner.nextLine();
        }
        int motherId = Integer.parseInt(motherIdStr);

        textInput.printAnswer("setFatherId");
        String fatherIdStr = scanner.nextLine();
        while (!(tests.testInt(fatherIdStr))) {
            fatherIdStr = scanner.nextLine();
        }
        int fatherId = Integer.parseInt(fatherIdStr);

        presenter.addChild(childId, motherId, fatherId);
    }
}
