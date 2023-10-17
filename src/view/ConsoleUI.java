package view;

import model.person.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View, ConsoleCommands{
    private static final String INPUT_ERROR = "Что то не то((";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void start() {
        System.out.println("Привет!!");
        while (work) {
            printMenu();
            execute();
        }
    }
    public void createFamilyTree() {
        System.out.println("Введите фамилию:");
        String family = scanner.nextLine();
        presenter.createFamilyTree(family);
        System.out.println("Создано новое пустое семейное дерево: " + family);
    }
    public void createCustomTree() {
        presenter.createCustomTree();
    }
    public void addInFamily() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите дату рождения:");

        System.out.println("\tдень");
        String strBirthDay = scanner.nextLine();
        int birthDay;
        if (checkTextForInt(strBirthDay)) {
            birthDay = Integer.parseInt(strBirthDay);
        } else {
            birthDay = 0;
        }

        System.out.println("\tмесяц");
        String strBirthMonth = scanner.nextLine();
        int birthMonth;
        if (checkTextForInt(strBirthMonth)) {
            birthMonth = Integer.parseInt(strBirthMonth);
        } else {
            birthMonth = 0;
        }

        System.out.println("\tгод");
        String strBirthYear = scanner.nextLine();
        int birthYear;
        if (checkTextForInt(strBirthYear)) {
            birthYear = Integer.parseInt(strBirthYear);
        } else {
            birthYear = 0;
        }

        System.out.println("Введите пол (м/ж):");
        String strGender = scanner.nextLine();
        Gender gender; // если реализовать данный switch в View, то появится пересечение с model
        switch (strGender) {
            case "м": {
                gender = Gender.Male;
                break;
            }
            case "ж": {
                gender = Gender.Female;
                break;
            }
            default: {
                gender = Gender.NonBinary;
                break;
            }
        }
        if (checkYear(birthYear) && checkMonth(birthMonth) && checkDay(birthDay)) {
            presenter.addInFamily(name, birthDay, birthMonth, birthYear, gender);
        }
    }
    public void addDeathDate() {
        presenter.getFamilyInfo();
        System.out.println("Введите id умершего члена семьи:");
        String deathPerson = scanner.nextLine();
        if (checkTextForInt(deathPerson)) {
            int deathPersonID = Integer.parseInt(deathPerson);
            if (checkID(deathPersonID)) {
                System.out.println("Введите дату сметри:");

                System.out.println("\tдень");
                String strDeathDay = scanner.nextLine();
                int deathDay;
                if (checkTextForInt(strDeathDay)) {
                    deathDay = Integer.parseInt(strDeathDay);
                } else {
                    deathDay = 0;
                }

                System.out.println("\tмесяц");
                String strDeathMonth = scanner.nextLine();
                int deathMonth;
                if (checkTextForInt(strDeathMonth)) {
                    deathMonth = Integer.parseInt(strDeathMonth);
                } else {
                    deathMonth = 0;
                }

                System.out.println("\tгод");
                String strDeathYear = scanner.nextLine();
                int deathYear;
                if (checkTextForInt(strDeathYear)) {
                    deathYear = Integer.parseInt(strDeathYear);
                } else {
                    deathYear = 0;
                }
                if (checkYear(deathDay) && checkMonth(deathMonth) && checkDay(deathYear)) {
                    presenter.addDeathDate(deathPersonID, LocalDate.of(deathDay, deathMonth, deathYear));
                }
            }
        }
    }
    public void getMarried() {
        presenter.getFamilyInfo();
        System.out.println("Введите id мужа:");
        String strHusband = scanner.nextLine();
        System.out.println("Введите id жены:");
        String strWife = scanner.nextLine();
        if (checkTextForInt(strHusband) && checkTextForInt(strWife)) {
            int husbandID = Integer.parseInt(strHusband);
            int wifeID = Integer.parseInt(strWife);
            if (checkID(husbandID) && checkID(wifeID)) {
                presenter.getMarried(husbandID, wifeID);
            }
        }
    }

    public void getChild() {
        presenter.getFamilyInfo();
        System.out.println("Введите id ребенка:");
        String strChild = scanner.nextLine();
        System.out.println("Введите id отца:");
        String strFather = scanner.nextLine();
        System.out.println("Введите id матери:");
        String strMother = scanner.nextLine();
        if (checkTextForInt(strChild) && checkTextForInt(strFather) && checkTextForInt(strMother)) {
            int childID = Integer.parseInt(strChild);
            int fatherID = Integer.parseInt(strFather);
            int motherID = Integer.parseInt(strMother);
            if (checkID(childID) && checkID(fatherID) && checkID(motherID)) {
                presenter.getChild(childID, fatherID, motherID);
            }
        }
    }
    public void getPersonInfo() {
        presenter.getFamilyInfo();
        System.out.println("Введите id человека:");
        String strPerson = scanner.nextLine();
        if (checkTextForInt(strPerson)) {
            int personID = Integer.parseInt(strPerson);
            if (checkID(personID)) {
                presenter.getPersonInfo(personID);
            }
        }
    }
    public void saveFamilyTree() {
        presenter.saveFamilyTree();
        System.out.println("Семейное дерево сохранено...");
    }
    public void downloadFamilyTree() {
        System.out.println("Введите фамилию:");
        String name = scanner.nextLine();
        presenter.downloadFamilyTree(name);
    }

    @Override
    public void sortByName() {
        presenter.sortByName();
    }

    @Override
    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void finish() {
        System.out.println("Пока");
        work = false;
    }
    public int getTreeSize() {
        return presenter.getTreeSize();
    }
    private void printMenu() {
        System.out.println(menu.menu());
    }
    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }
    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private boolean checkYear(int year) {
        if (year != 0) {
            return true;
        } else {
            System.out.println("Введен некорректный год!!");
            return false;
        }
    }
    private boolean checkMonth(int month) {
        if (month >= 1 && month <= 12) {
            return true;
        } else {
            System.out.println("Введен некорректный месяц!!");
            return false;
        }
    }
    private boolean checkDay(int day) {
        if (day >= 1 && day <= 31) {
            return true;
        } else {
            System.out.println("Введен некорректный день!!");
            return false;
        }
    }

    private boolean checkID(int id) {
        if (id >= 1 && id <= getTreeSize()) {
            return true;
        } else {
            System.out.println("Человека с таким id не найдено!!");
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}
