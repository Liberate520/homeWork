package view.console.commands;

import view.console.ConsoleUI;

public class AddNewHumanInTree extends Command {
    public AddNewHumanInTree(ConsoleUI consoleUI) {
        super("добавить нового человека в древо", consoleUI);
    }

    public void execute() {
        consoleUI.addNewHumanInTree();
    }
}