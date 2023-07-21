package FamilyTree.View.commands;

import FamilyTree.View.ConsoleUI;

import java.io.IOException;

public class Tree extends Command {
    public Tree (ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Работа с деревом";
    }

    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.tree();
    }
}