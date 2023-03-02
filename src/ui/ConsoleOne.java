package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import presenter.Presenter;
import ui.menu.Menu;

public class ConsoleOne implements View {

    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private Boolean run = true;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        demoTree();
        while (run) {
            showMenu();
            String command = scanner.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command) - 1);
            } else {
                System.out.println("Your input isn't a number");
            }
        }
    }

    public void demoTree() {
        System.out.println("Load demo tree? y/n");
        if (yesNoCheck(scanner.nextLine())) {
            presenter.demo();
        }
    }

    private boolean yesNoCheck(String text) {
        if (text.equalsIgnoreCase("y") || text.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkInput(String text) {
        return text.matches("[0-9]+");
    }

    public void addTreeEntity() {
        String name, lastName, sex, dateOfBirth;
        LocalDate birthDate;
        System.out.println("Enter first name: ");
        name = scanner.nextLine();

        System.out.println("Enter last name: ");
        lastName = scanner.nextLine();

        System.out.println("Enter sex (format: m/f or male/female): ");
        sex = scanner.nextLine();

        System.out.println("Enter date of birth (format: 01 01 2000)");
        dateOfBirth = scanner.nextLine();
        birthDate = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd MM uuuu"));

        presenter.addTreeEntity(name, lastName, sex, birthDate);
    }

    public void showEntityInfo() {
        String num;
        while (true) {
            System.out.print("Enter id number: ");
            num = scanner.nextLine();
            if (checkInput(num)) {
                presenter.showEntityInfo(Integer.parseInt(num));
                break;
            }
        }
    }

    public void printTree() {
        presenter.printTree();
    }

    public void exit() {
        run = false;
        System.out.println("Good bye");
    }

    private void showMenu() {
        System.out.println("\nChoose option:");
        System.out.println(menu.stringMenu());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

}
