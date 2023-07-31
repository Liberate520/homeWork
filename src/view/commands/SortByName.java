package view.commands;

import view.ConsoleUI;

public class SortByName extends Command {
    private String description;
    private ConsoleUI consoleUI;


    public SortByName(ConsoleUI consoleUI) {
        super("Sorting members by age", consoleUI);
    }

    public void execute(){
        getConsoleUI().sortByName();
    }

    public String getDescription() {
        return description;
    }
}
