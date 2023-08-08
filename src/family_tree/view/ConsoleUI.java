package family_tree.view;


import family_tree.presenter.Presenter;
import family_tree.view.console_commands.*;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;
    private TextConsole textConsole;
    private IsNumeric isNumeric;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
        textConsole = new TextConsole();
        isNumeric = new IsNumeric();
    }

    public void addHuman() {
        ConsoleAddHuman consoleAddHuman = new ConsoleAddHuman();
        if (consoleAddHuman.addHuman()) {
            presenter.addHuman(consoleAddHuman.getName(), consoleAddHuman.getGender(), consoleAddHuman.getLocalDate());
        }
    }

    public void wedding() {
        ConsoleWedding consoleWedding = new ConsoleWedding();
        if (consoleWedding.wedding()) {
            presenter.wedding(consoleWedding.getIdHusband(), consoleWedding.getIdWife());
        }
    }

    public void addChildren() {
        ConsoleAddChildren consoleAddChildren = new ConsoleAddChildren();
        if (consoleAddChildren.addChildren()) {
            presenter.addChildren(consoleAddChildren.getIdChildren(), consoleAddChildren.getIdFather(),
                    consoleAddChildren.getIdMother());
        }
    }

    public void addParents() {
        ConsoleAddParents consoleAddParents = new ConsoleAddParents();
        if (consoleAddParents.addParents()) {
            presenter.addParents(consoleAddParents.getIdChildren(), consoleAddParents.getIdFather(),
                    consoleAddParents.getIdMother());
        }
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

    @Override
    public void start() {
        while (work) {
            System.out.println(textConsole.greetingsText);
            System.out.println(menu.menu());
            System.out.println(textConsole.choiceText);
            String choice = scanner.nextLine();
            if (isNumeric.checkNum(choice)) {
                int choiceInt = Integer.parseInt(choice);
                if (choiceInt > 0 && choiceInt <= menu.getSize()) {
                    menu.execute(choiceInt);
                } else {
                    System.out.println(textConsole.choiceTextErr);
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
