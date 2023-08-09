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
    private IConsoleAddHuman consoleAddHuman;
    private IConsoleAddChildren consoleAddChildren;
    private IConsoleAddParents consoleAddParents;
    private IConsoleWedding consoleWedding;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
        textConsole = new TextConsole();
        isNumeric = new IsNumeric();
        consoleAddHuman = new ConsoleAddHuman();
        consoleAddChildren = new ConsoleAddChildren();
        consoleAddParents = new ConsoleAddParents();
        consoleWedding = new ConsoleWedding();
    }

    public void addHuman() {
        if (consoleAddHuman.addHumanCon()) {
            presenter.addHuman(consoleAddHuman.getName(), consoleAddHuman.getGender(), consoleAddHuman.getLocalDate());
        }
    }

    public void wedding() {
        if (consoleWedding.weddingCon()) {
            presenter.wedding(consoleWedding.getIdHusband(), consoleWedding.getIdWife());
        }
    }

    public void addChildren() {
        if (consoleAddChildren.addChildrenCon()) {
            presenter.addChildren(consoleAddChildren.getIdChildren(), consoleAddChildren.getIdFather(),
                    consoleAddChildren.getIdMother());
        }
    }

    public void addParents() {
        if (consoleAddParents.addParentsCon()) {
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
