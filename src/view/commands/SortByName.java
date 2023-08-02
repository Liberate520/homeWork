package view.commands;

import view.ConsoleUI;

public class SortByName extends Command {
    private String description;
    private ConsoleUI consoleUI;


    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description ="Sorting members by name" ;
    }

    public void execute(){
        getConsoleUI().sortByName();
    }

    public String getDescription() {
        return description;
    }
}
