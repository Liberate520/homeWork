package ru.java_oop.family_tree.view;

import ru.java_oop.family_tree.model.human.Gender;
import ru.java_oop.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private boolean working;
    private MainMenu menu;
    private Scanner scanner;

    public ConsoleUI() {
        this.presenter = new Presenter(this);
        this.working = true;
        this.menu = new MainMenu(this);
        this.scanner = new Scanner(System.in);
    }


    public void endProgram() {
        System.out.println("Exiting program");
        this.working = false;
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (working) {
            System.out.println(menu.formMenu());
            String line = scanner.nextLine();
            try {
                int choice = Integer.parseInt(line);
                if (choice > menu.getSize()) {
                    System.out.println("Incorrect input");
                } else {
                    menu.execute(choice);
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + "Incorrect input");
            }
        }
    }

    public void addHuman() {
        System.out.println("Enter human name: ");
        String name = scanner.nextLine();
        boolean incorrect = true;
        Gender gender = Gender.Male;
        while (incorrect) {
            System.out.println("Enter human gender (Male/Female): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("male")) {
                incorrect = false;
            } else if (input.equalsIgnoreCase("female")) {
                gender = Gender.Female;
                incorrect = false;
            } else {
                System.out.println("Incorrect input");
            }
        }
        incorrect = true;
        LocalDate birthdate = null;
        while (incorrect) {
            System.out.println("Enter birth-date (yyyy-mm-dd): ");
            try {
                birthdate = LocalDate.parse(scanner.nextLine());
                incorrect = false;
            } catch (Exception e) {
                System.out.println("Incorrect input. " + e.getMessage());
            }
        }
        presenter.addHumanFamilyMember(name, gender, birthdate);
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    public void setParentChildRelation() {
        long parent_choice, child_choice;
        System.out.println("Current tree: ");
        getFamilyTreeInfo();
        System.out.println("\nChoose parent ID: ");
        parent_choice = Long.parseLong(scanner.nextLine());
        System.out.println("\nChoose child ID: ");
        child_choice = Long.parseLong(scanner.nextLine());

        presenter.setParentRelation(parent_choice, child_choice);
    }

    public void saveFamilyTreeToFile() {
        System.out.println("Enter file name: ");
        String fileName = scanner.nextLine();
        presenter.saveFamilyTreeToFile(fileName);
        System.out.println("Saved!");
    }

    public void loadFamilyTreeFromFile() {
        System.out.println("Enter file name: ");
        String fileName = scanner.nextLine();
        presenter.loadFamilyTreeFromFile(fileName);
        System.out.println("Loaded!");
    }

}
