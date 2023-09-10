package view.commands;

import view.ConsoleUI;

public class AddTreeItem extends Command{
    public AddTreeItem(ConsoleUI consoleUI) {
        super("Add item to tree", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().getHuman();
    }
}
