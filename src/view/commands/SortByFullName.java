package view.commands;

import view.ConsoleUI;

public class SortByFullName extends Command {
    public SortByFullName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort family tree by full name.";
    }

    public void execute(){
        consoleUI.sortByFullName();
    }
}
