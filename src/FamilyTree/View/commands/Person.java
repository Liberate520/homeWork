package FamilyTree.View.commands;

import FamilyTree.View.ConsoleUI;

import java.io.IOException;

public class Person  extends Command {
    public Person (ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Работа с записью о человеке";
    }

    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.person();
    }
}
