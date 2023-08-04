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

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
    }

    public void addHuman() {
        System.out.println("Укажите имя");

        String name = scanner.nextLine();
        System.out.println("Укажите пол 1 - мужской, 2 - женский");
        String gen = scanner.nextLine();
        if (!isNumeric(gen)) {
            System.out.println("Пол указан неверно");
            return;
        }
        int iGen = Integer.parseInt(gen);
        Gender gender;
        if (iGen == 1) {
            gender = Male;
        } else if (iGen == 2) {
            gender = Female;
        } else {
            System.out.println("Пол указан неверно");
            return;
        }

        System.out.println("Укажите год рождения");
        String year = scanner.nextLine();
        if (!isNumeric(year)) {
            System.out.println("Год рождения указан не верно");
            return;
        }
        int iYear = Integer.parseInt(year);

        System.out.println("Укажите месяц рождения");
        String month = scanner.nextLine();
        if (!isNumeric(month)) {
            System.out.println("Месяц рождения указан не верно");
            return;
        }
        int iMonth = Integer.parseInt(month);
        if (iMonth < 1 || iMonth > 12) {
            System.out.println("Месяц рождения указан не верно");
            return;
        }

        System.out.println("Укажите день рождения");
        String dayOfMonth = scanner.nextLine();
        if (!isNumeric(dayOfMonth)) {
            System.out.println("День рождение указан не верно");
            return;
        }

        int iDayOfMonth = Integer.parseInt(dayOfMonth);
        YearMonth yearMonth = YearMonth.of(iYear, iMonth);
        int day = yearMonth.lengthOfMonth();
        if (iDayOfMonth < 0 || iDayOfMonth > day) {
            System.out.println("Дата рождения указана не верно");
            return;
        }
        presenter.addHuman(name, gender, LocalDate.of(iYear, iMonth, iDayOfMonth));
    }

    public void wedding() {
        System.out.println("Укажите id мужа");
        String husband = scanner.nextLine();
        if (!isNumeric(husband)) {
            System.out.println("id введен неверно");
            return;
        }
        long idHusband = Integer.parseInt(husband);

        System.out.println("Укажите id жены");
        String wife = scanner.nextLine();
        if (!isNumeric(wife)) {
            System.out.println("id введен неверно");
            return;
        }
        long idWife = Integer.parseInt(wife);
        presenter.wedding(idHusband, idWife);

    }

    public void addChildren() {
        System.out.println("Укажите id ребенка");
        String children = scanner.nextLine();
        if (!isNumeric(children)) {
            System.out.println("id введен неверно");
            return;
        }
        long idChildren = Integer.parseInt(children);

        System.out.println("Укажите id отца");
        String father = scanner.nextLine();
        if (!isNumeric(father)) {
            System.out.println("id введен неверно");
            return;
        }
        long idFather = Integer.parseInt(father);

        System.out.println("Укажите id матери");
        String mother = scanner.nextLine();
        if (!isNumeric(mother)) {
            System.out.println("id введен неверно");
            return;
        }
        long idMother = Integer.parseInt(mother);

        presenter.addChildren(idChildren, idFather, idMother);
    }

    public void addParents() {
        System.out.println("Укажите id ребенка");
        String children = scanner.nextLine();
        if (!isNumeric(children)) {
            System.out.println("id введен неверно");
            return;
        }
        long idChildren = Integer.parseInt(children);

        System.out.println("Укажите id отца");
        String father = scanner.nextLine();
        if (!isNumeric(father)) {
            System.out.println("id введен неверно");
            return;
        }
        long idFather = Integer.parseInt(father);

        System.out.println("Укажите id матери");
        String mother = scanner.nextLine();
        if (!isNumeric(mother)) {
            System.out.println("id введен неверно");
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
        System.out.println("Дерево открыто");
    }

    public void saveFile() {
        presenter.saveFile();
        System.out.println("Дерево записано");
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
            System.out.println("Здравствуйте");
            System.out.println(menu.menu());
            System.out.println("Выберете пункт меню");
            String choice = scanner.nextLine();
            if (isNumeric(choice)) {
                int choiceInt = Integer.parseInt(choice);
                if (choiceInt > 0 && choiceInt <= menu.getSize()) {
                    menu.execute(choiceInt);
                } else {
                    System.out.println("Вы ввели неверный пункт меню");
                }
            } else {
                System.out.println("Введите число");
            }

        }

    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
