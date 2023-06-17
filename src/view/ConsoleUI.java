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

    public void addHuman() {
        print("Укажите имя");
        String firstName = inputName();;
        print("Укажите фамилию");
        String lastName = inputName();

        print("Укажите дату рождения (в формате гггг-мм-дд)");
        LocalDate birthDate = getDate(inputDate());

        print("Укажите дату смерти, если есть (в формате гггг-мм-дд), или нажмите Enter");
        LocalDate deathDate = getDate(inputDate());

        print("Укажите имя матери, если есть, или нажмите Enter");
        String firstMomName = inputName();
        print("Укажите фамилию матери, если есть, или нажмите Enter");
        String lastMomName = inputName();

        print("Укажите имя и фамилию отца, если есть, или нажмите Enter");
        String firstDadName = inputName();
        print("Укажите имя и фамилию отца, если есть, или нажмите Enter");
        String lastDadName = inputName();

        presenter.addHuman(firstName, lastName, birthDate, deathDate,
                firstMomName, lastMomName, firstDadName, lastDadName);
    }

    private boolean checkEmptyEnter(String input) {
        return input.isEmpty();
    }

    private boolean checkName(String name) {
//        if (!name.matches("^[\\p{L} .'-]+$")) {
//        if (!name.isEmpty() && !name.matches("[^\\W\\d_]")) {
//            return false;
//        }
//        return name.matches("^[\\p{L}.]+$");
        return name.matches("^[\\p{L}]+$");
    }

    private String inputName() {
        String name = scan();
        while (!checkName(name)) {
            print("Ошибка ввода имени или фимилии, повторите попытку");
            name = scan();
        }
        return name;
    }

    private String[] getFullName(String name) {
        if (name == null) {
            name = "Неизвестно";
        }
        return name.split(" ");
    }

    private boolean checkDate(String dateLine) {
        if (!dateLine.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            return false;
        }
        return true;
    }

    private String inputDate() {
        String date = scan();
        if (!date.isEmpty()) {

            String localDate = LocalDate.now().toString();
            while (!checkDate(date) && date.equals(localDate)) {
                print("Ошибка ввода даты, повторите попытку");
                date = scan();
            }
            return date;
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

    public void getHumanByBirthDate() {
        print("Укажите год рождения человека для поиска");
        String year = enterYear();
        presenter.getHumanByBirthDate(year);
    }

    private String enterYear() {
        String year = scan();
        if (!year.isEmpty()) {
            while (!checkYear(year)) {
                print("Ошибка. Год введён неправильно, повторите попытку");
                year = scan();
            }
            return year;
        } else {
            return null;
        }
    }

    private boolean checkYear(String year) {
        if (!year.matches("[0-9]{4}")) {
            return false;
        }
        return true;
    }

    public void getHumanByName() {
        print("Укажите имя человека для поиска");
        String firstName = inputName();
        print("Укажите фамилию человека для поиска");
        String lastName = inputName();
        presenter.getHumanByName(firstName, lastName);
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
}
