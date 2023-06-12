package view;

import presenter.Presenter;

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
        presenter = new Presenter();
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    private String scan() {
        return scanner.nextLine();
    }

    public void run() {
        print("-----Добро пожаловать в генеологическое дерево!-----");
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

    public void stop() {
        print("Ещё увидимся! Удачи!");
        work = false;
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

    private String unknownMsg() {
        return "неизвестно";
    }

    public void addHuman() {
        print("Укажите имя и фамилию (через пробел)");
        String name = enterName();
        String firstName = getFullName(name)[0];
        String lastName = getFullName(name)[1];

        print("Укажите дату рождения (в формате гггг-мм-дд)");
        LocalDate birthDate = getDate(enterDate());

        print("Укажите дату смерти, если есть (в формате гггг-мм-дд), или нажмите Enter");
        LocalDate deathDate = getDate(enterDate());

        print("Укажите имя и фамилию матери, если есть (через пробел), или нажмите Enter");
        String mom = enterName();
        String firstMomName = getFullName(mom)[0];
        String lastMomName = getFullName(mom)[1];

        print("Укажите имя и фамилию отца, если есть (через пробел), или нажмите Enter");
        String dad = enterName();
        String firstDadName = getFullName(dad)[0];
        String lastDadName = getFullName(dad)[1];

        presenter.addHuman(firstName, lastName, birthDate, deathDate,
                firstMomName, lastMomName, firstDadName, lastDadName);
    }

    private boolean checkEmptyEnter(String entered) {
        return entered.isEmpty();
    }

    private boolean checkName(String name) {
        if (!name.matches("^[\\p{L} .'-]+$")) {
            return false;
        }
        return true;
    }

    private String enterName() {
        String name = scan();
        if (!checkEmptyEnter(name)) {
            while (!checkName(name)) {
                print("Ошибка ввода имени или фимилии, повторите попытку");
                name = scan();
            }
            return name;
        } else {
            return null;
        }
    }

    private String[] getFullName(String name) {
        if (name == null) {
            name = unknownMsg() + " " + unknownMsg();
        }
        return name.split(" ");
    }

    private boolean checkDate(String dateLine) {
        if (!dateLine.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            return false;
        }
        return true;
    }

    private String enterDate() {
        String date = scan();
        if (!checkEmptyEnter(date)) {

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
        if (!checkEmptyEnter(year)) {
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
        print("Укажите имя и фамилию человека длл поиска (через пробел)");
        String name = enterName();
        String firstName = getFullName(name)[0];
        String lastName = getFullName(name)[1];
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
