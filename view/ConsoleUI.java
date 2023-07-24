package homeWork.view;

import java.util.Scanner;

import homeWork.presenter.Presenter;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void addHuman() {
        System.out.println("Введите имя ");
        String name = scanner.nextLine();
        System.out.println("Укажите возраст ");
        String ageString = scanner.nextLine();
        // сделать проверку ввода возраста
        int age = Integer.parseInt(ageString);
        presenter.addHuman(name, age);
    }

    public void getHumanInfo() {
        presenter.getHumanInfo();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void finish() {
        System.out.println("Бай-бай!");
        work = false;
    }

    private void hello() {
        System.out.println("Хааааааай!");
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

    private boolean checkCommand(int numCommand) {
        if (numCommand < menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

}
