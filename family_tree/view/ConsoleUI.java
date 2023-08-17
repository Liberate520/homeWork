package homeWork.family_tree.view;

import homeWork.family_tree.model.human.Gender;
import homeWork.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String errorInput = "Вы ввели неверное значение";
    private Presenter presenter;
    private final Scanner scanner;
    private boolean work;
    private final MainMenu menu;

    public ConsoleUI(Presenter presenter) {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    private void hello() {
        System.out.println("Доброго времени суток!");
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    public void addHuman() {
        System.out.println("Укажите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите пол человека");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Укажите возраст человека");
        String birthDateString = scanner.nextLine();
        int birthDate = Integer.parseInt(birthDateString);
        presenter.addHuman(name, Gender.valueOf(String.valueOf(gender)), LocalDate.parse(String.valueOf(birthDate)));
    }

    public void getHumanInfo() {
        presenter.getHumanInfo();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void errorInput() {
        System.out.println("Вы ввели некорректное значение");
    }

    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
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

    public void loadFamily() {
        presenter.loadFamily();
    }


    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            errorInput();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand < menu.getSize()) {
            return true;
        } else {
            errorInput();
            return false;
        }
    }

    public void saveFamily() {
        presenter.saveFamily();
    }
}
