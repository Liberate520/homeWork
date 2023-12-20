package ru.gb.family_tree.view;


import model.creatures.Gender;
import presenter.Presenter;
import view.input.ConsoleInput;
import view.input.Input;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//TODO: Вынести обработку исключений в отдельный класс

public class ConsoleUI implements View {
    private final Scanner scanner;
    private final Input input;
    private boolean work;
    private final MainMenu menu;
    private Presenter presenter;

    public ConsoleUI() {
        this.input = new ConsoleInput();
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter();
        work = true;
        menu = new MainMenu(this);
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    @Override
    public void start() {
        System.out.println("Hello!\nEnter the menu item in the console and press Enter");
        while (work) {
            printMenu();
            execute();
        }
    }

    public void addCreature() {
        Gender gend = Gender.Male;
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your last name\n: ");
        String lastName = scanner.nextLine();
        boolean flag = false;
        System.out.println("Choose a gender: 1. Male, 2. Female");
        while (!flag) {
            int gender = input.rangeIntInput(1, 2);
            if (gender == 2) {
                gend = Gender.Female;
                flag = true;
            }
            if (gender == 1) {
                gend = Gender.Male;
                flag = true;
            } else {
                System.out.println("Enter the gender correctly: 1. Male, 2. Female");
            }
        }
        flag = false;
        LocalDate date = null;
        while (!flag) {
            try {
                System.out.println("Enter your date of birth in the year-month-day format: (1990-09-10):");
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(scanner.nextLine(), dateFormat);
                flag = true;
            } catch (DateTimeParseException ignored) {
            }
        }
        if (presenter.addCreature(name, lastName, gend, date)) {
            System.out.println("The person has been successfully added!");
        } else {
            System.out.println("It was not possible to create such a person");
        }
    }

    public void showTree() {
        System.out.println(presenter.showTree());
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void execute() {
        try {
            menu.execute(input.intInput());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter the correct menu item number");
        }
    }

    public void showNotInTree() {
        System.out.println(presenter.showNotInTree());
    }

    public void setChild() {
        System.out.println("Enter the parent's ID:");
        Integer parentID = input.intInput();
        System.out.println("Enter the child's ID:");
        Integer childID = input.intInput();
        if (presenter.setChild(parentID, childID)) {
            System.out.println("The child has been successfully assigned");
        } else {
            System.out.println("It was not possible to set a child with such parameters");
        }
    }

    public void showAll() {
        System.out.println(presenter.showAll());
    }

    public void ShowAllInfo() {
        System.out.println("Enter the person's ID");
        Integer id = input.intInput();
        System.out.println(presenter.showAllInfo(id));
    }

    public void showHumanTree() {
        System.out.println(presenter.showHumanTree());
    }

    public void setSpouce() {
        System.out.println("Enter the ID of the first spouse");
        Integer id = input.intInput();
        System.out.println("Enter the ID of the second spouse");
        Integer id2 = input.intInput();
        if (presenter.setSpouce(id, id2)) {
            System.out.println("The spouses have been set successfully!");
        } else {
            System.out.println("The command could not be executed");
        }

    }

    public void saveFamilyTree() {
        System.out.println("Enter the file name: ");
        if (presenter.saveFamilyTree(scanner.nextLine())) {
            System.out.println("The changes were saved successfully");
        } else {
            System.out.println("The changes could not be saved");
        }

    }

    public void loadFamilyTree() {
        System.out.println("Enter the file name: ");
        if (presenter.loadFamilyTree(scanner.nextLine())) {
            System.out.println("The tree has been loaded successfully");
        } else {
            System.out.println("Failed to download from file");
        }
    }

    public void SetDivorce() {
        System.out.println("Enter the ID of the first spouse");
        Integer id = input.intInput();
        System.out.println("Enter the ID of the second spouse");
        Integer id2 = input.intInput();
        if (presenter.setDivorce(id, id2)) {
            System.out.println("The command was executed successfully");
        } else {
            System.out.println("The command could not be executed");
        }
    }

    public void setFather() {
        System.out.println("Enter the child's ID:");
        Integer childId = input.intInput();
        System.out.println("Enter the father's ID:");
        Integer fatherId = input.intInput();
        if (presenter.setFather(childId, fatherId)) {
            System.out.println("The father has been successfully assigned");
        } else {
            System.out.println("It was not possible to set the father with such parameters");
        }
    }

    public void setMother() {
        System.out.println("Enter the child's ID:");
        Integer childId = input.intInput();
        System.out.println("Enter the mother's ID:");
        Integer motherID = input.intInput();
        if (presenter.setMother(childId, motherID)) {
            System.out.println("The mother has been successfully assigned");
        } else {
            System.out.println("It was not possible to set the mother with such parameters");
        }
    }

    public void setDeathDate() {
        boolean flag = false;
        LocalDate date = null;
        System.out.println("Enter the person's ID:");
        Integer humanID = input.intInput();
        while (!flag) {
            try {
                System.out.println("Enter the date of death in the year-month-day format: (1990-09-10):");
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(scanner.nextLine(), dateFormat);
                flag = true;
            } catch (DateTimeParseException ignored) {
            }
        }
        if (presenter.setDeathDate(humanID, date)) {
            System.out.println("The date of death has been successfully set");
        } else {
            System.out.println("Couldn't set the date of death");
        }
    }
}