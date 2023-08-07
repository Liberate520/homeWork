package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

import static family_tree.model.human.Gender.Female;
import static family_tree.model.human.Gender.Male;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;
    private TextConsole textConsole;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
        textConsole = new TextConsole();

    }

    public void addHuman() {
        System.out.println(textConsole.indicateNameText);

        String name = scanner.nextLine();
        System.out.println(textConsole.indicateGenderText);
        String gen = scanner.nextLine();
        if (!isNumeric(gen)) {
            System.out.println(textConsole.genderIsIncorrectText);
            return;
        }
        int iGen = Integer.parseInt(gen);
        Gender gender;
        if (iGen == 1) {
            gender = Male;
        } else if (iGen == 2) {
            gender = Female;
        } else {
            System.out.println(textConsole.genderIsIncorrectText);
            return;
        }

        System.out.println(textConsole.enterYearOfBirthText);
        String year = scanner.nextLine();
        if (!isNumeric(year)) {
            System.out.println(textConsole.enterYearOfBirthErrText);
            return;
        }
        int iYear = Integer.parseInt(year);

        System.out.println(textConsole.enterMonthOfBirthText);
        String month = scanner.nextLine();
        if (!isNumeric(month)) {
            System.out.println(textConsole.enterMonthOfBirthErrText);
            return;
        }
        int iMonth = Integer.parseInt(month);
        if (iMonth < 1 || iMonth > 12) {
            System.out.println(textConsole.enterMonthOfBirthErrText);
            return;
        }

        System.out.println(textConsole.enterBirthdayText);
        String dayOfMonth = scanner.nextLine();
        if (!isNumeric(dayOfMonth)) {
            System.out.println(textConsole.enterBirthdayErrText);
            return;
        }

        int iDayOfMonth = Integer.parseInt(dayOfMonth);
        YearMonth yearMonth = YearMonth.of(iYear, iMonth);
        int day = yearMonth.lengthOfMonth();
        if (iDayOfMonth < 0 || iDayOfMonth > day) {
            System.out.println(textConsole.enterBirthdayErrText);
            return;
        }
        presenter.addHuman(name, gender, LocalDate.of(iYear, iMonth, iDayOfMonth));
    }

    public void wedding() {
        System.out.println(textConsole.enterHusbandIdText);
        String husband = scanner.nextLine();
        if (!isNumeric(husband)) {
            System.out.println(textConsole.idErrText);
            return;
        }
        long idHusband = Integer.parseInt(husband);

        System.out.println(textConsole.enterWifeIdText);
        String wife = scanner.nextLine();
        if (!isNumeric(wife)) {
            System.out.println(textConsole.idErrText);
            return;
        }
        long idWife = Integer.parseInt(wife);
        presenter.wedding(idHusband, idWife);

    }

    public void addChildren() {
        System.out.println(textConsole.enterChildrenIdText);
        String children = scanner.nextLine();
        if (!isNumeric(children)) {
            System.out.println(textConsole.idErrText);
            return;
        }
        long idChildren = Integer.parseInt(children);

        System.out.println(textConsole.enterFatherIdText);
        String father = scanner.nextLine();
        if (!isNumeric(father)) {
            System.out.println(textConsole.idErrText);
            return;
        }
        long idFather = Integer.parseInt(father);

        System.out.println(textConsole.enterMotherIdText);
        String mother = scanner.nextLine();
        if (!isNumeric(mother)) {
            System.out.println(textConsole.idErrText);
            return;
        }
        long idMother = Integer.parseInt(mother);

        presenter.addChildren(idChildren, idFather, idMother);
    }

    public void addParents() {
        System.out.println(textConsole.enterChildrenIdText);
        String children = scanner.nextLine();
        if (!isNumeric(children)) {
            System.out.println(textConsole.idErrText);
            return;
        }
        long idChildren = Integer.parseInt(children);

        System.out.println(textConsole.enterFatherIdText);
        String father = scanner.nextLine();
        if (!isNumeric(father)) {
            System.out.println(textConsole.idErrText);
            return;
        }
        long idFather = Integer.parseInt(father);

        System.out.println(textConsole.enterMotherIdText);
        String mother = scanner.nextLine();
        if (!isNumeric(mother)) {
            System.out.println(textConsole.idErrText);
            return;
        }
        long idMother = Integer.parseInt(mother);

        presenter.addParents(idChildren, idFather, idMother);

    }

    public void finish() {
        work = false;
    }

    public void printInfo() {
        presenter.getHumanListInfo();
    }

    public void readFile() {
        presenter.readFile();
        System.out.println(textConsole.openTreeText);
    }

    public void saveFile() {
        presenter.saveFile();
        System.out.println(textConsole.saveTreeText);
    }

    public boolean isNumeric(String str) {
        // Проверка на число
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void start() {
        while (work) {
            System.out.println(textConsole.greetingsText);
            System.out.println(menu.menu());
            System.out.println(textConsole.choiceText);
            String choice = scanner.nextLine();
            if (isNumeric(choice)) {
                int choiceInt = Integer.parseInt(choice);
                if (choiceInt > 0 && choiceInt <= menu.getSize()) {
                    menu.execute(choiceInt);
                } else {
                    System.out.println(textConsole.choiceText);
                }
            } else {
                System.out.println(textConsole.enterNumber);
            }

        }

    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
