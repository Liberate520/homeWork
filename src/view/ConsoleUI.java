package view;

import model.human.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag = true;
    private MainMenu mainMenu;

    public ConsoleUI() {
         presenter = new Presenter(this);
         scanner = new Scanner(System.in);
         mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        while (flag) {
            printMenu();
            scanMenu();
        }
    }

    private void scanMenu() {
        String choice = scanner.nextLine();
        mainMenu.execute(Integer.parseInt(choice));
    }

    private void error() {
        System.out.println("\n Error, try again.\n");
    }
    public void finish() {
        flag = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFamilyTree() {
        presenter.getFamilyTree();
    }

    public void addElement() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("BD (YYYY-MM-DD):");
        LocalDate bd = LocalDate.parse(scanner.nextLine());
        System.out.println("Gender (M/F):");
        Gender gender = Gender.male;
        if (Objects.equals(scanner.nextLine(), "F")) {
            gender = Gender.female;
        }
        presenter.addElement(name, bd, gender);
    }

    private void printMenu() {
        System.out.println(mainMenu.print());
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }
}
