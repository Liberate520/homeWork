package view;

import presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void run() throws IOException, ClassNotFoundException {
        print("-----Добро пожаловать в генеологическое дерево!-----");
        printMainMenu();
    }

    public void stop() {
        print("Ещё увидимся! Удачи!");
        work = false;
    }

    public String scan() {
        return scanner.nextLine();
    }

    public void printMainMenu() throws IOException, ClassNotFoundException {
        while (work) {
            print(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1) {
                print("Ошибка ввода");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scan();
        if (!checkChoiceNumMenu(line)) {
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkChoiceNumMenu(String line) {
        if (!line.matches("[0-9]+")) {
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }

    private String[] addHumanName() {
        print("Укажите имя");
        String firstName = inputRequiredName();
        print("Укажите фамилию");
        String lastName = inputRequiredName();
        return new String[]{firstName, lastName};
    }

    private LocalDate addHumanBirthDate() {
        print("Укажите дату рождения (в формате гггг-мм-дд)");
        return getDate(inputRequiredDate());
    }

    private LocalDate addHumanDeathDate() {
        print("Укажите дату смерти, если есть (в формате гггг-мм-дд), или нажмите Enter");
        return getDate(inputOptionalDate());
    }

    private String[] addHumanMotherName() {
        print("Укажите имя матери, если есть, или нажмите Enter");
        String firstMomName = inputOptionalName();
        print("Укажите фамилию матери, если есть, или нажмите Enter");
        String lastMomName = inputOptionalName();
        return new String[]{firstMomName, lastMomName};
    }

    private String[] addHumanFatherName() {
        print("Укажите имя и фамилию отца, если есть, или нажмите Enter");
        String firstDadName = inputOptionalName();
        print("Укажите имя и фамилию отца, если есть, или нажмите Enter");
        String lastDadName = inputOptionalName();
        return new String[]{firstDadName, lastDadName};
    }

    public void addHuman() {
        String[] humanName = addHumanName();
        LocalDate birthDate = addHumanBirthDate();
        LocalDate deathDate = addHumanDeathDate();
        String[] momName = addHumanMotherName();
        String[] dadName = addHumanFatherName();
        presenter.addHuman(humanName[0], humanName[1], birthDate, deathDate,
                momName[0], momName[1], dadName[0], dadName[1]);
    }

    private boolean checkName(String name) {
        return name.matches("^[\\p{L}]+$");
    }

    private String inputNameValidation(String name) {
        while (!checkName(name)) {
            print("Ошибка ввода имени или фимилии, повторите попытку");
            name = scan();
        }
        return name;
    }

    private String inputRequiredName() {
        String name = scan();
        return inputNameValidation(name);
    }

    private String inputOptionalName() {
        String name = scan();
        if (!name.isEmpty()) {
            return inputNameValidation(name);
        } else {
            return null;
        }
    }

    private boolean checkDate(String dateLine) {
        if (!dateLine.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            return false;
        }
        return true;
    }

    private String inputDateValidation(String date) {
        String localDate = LocalDate.now().toString();
        while (!checkDate(date) && date.equals(localDate)) {
            print("Ошибка ввода даты, повторите попытку");
            date = scan();
        }
        return date;
    }

    private String inputRequiredDate() {
        String date = scan();
        return inputDateValidation(date);
    }

    private String inputOptionalDate() {
        String date = scan();
        if (!date.isEmpty()) {
            return inputDateValidation(date);
        } else {
            return null;
        }
    }

    private LocalDate getDate(String date) {
        if (date != null) {
            return LocalDate.parse(date);
        } else {
            return null;
        }
    }

    public void getHumanList() {
        print("-----Фамильное дерево-----");
        presenter.getHumanList();
    }

    private String inputSearchYear() {
        print("Укажите год рождения человека для поиска");
        return inputYear();
    }
    public void getHumanByBirthDate() {
        presenter.getHumanByBirthDate(inputSearchYear());
    }

    private String inputYearValidation(String year) {
        while (!checkYear(year)) {
            print("Ошибка. Год введён неправильно, повторите попытку");
            year = scan();
        }
        return year;
    }

    private String inputYear() {
        String year = scan();
        return inputYearValidation(year);
    }

    private boolean checkYear(String year) {
        if (!year.matches("[0-9]{4}")) {
            return false;
        }
        return true;
    }

    private String[] inputSearchName() {
        print("Укажите имя человека для поиска");
        String firstName = inputRequiredName();
        print("Укажите фамилию человека для поиска");
        String lastName = inputRequiredName();
        return new String[]{firstName, lastName};
    }

    public void getHumanByName() {
        presenter.getHumanByName(inputSearchName()[0], inputSearchName()[1]);
    }

    public void sortByChildrenCount() {
        presenter.sortByChildrenCount();
    }

    public void sortByLastName() {
        presenter.sortByLastName();
    }

    public void sortByFirstName() {
        presenter.sortByFirstName();
    }

    public void saveTree() throws IOException {
        presenter.saveTree();
    }

    public void loadTree() throws IOException, ClassNotFoundException {
        presenter.loadTree();
    }
}
