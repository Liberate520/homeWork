package view.commands;

import view.ConsoleUI;

public class SortByName extends Command {
    private String description;
    private ConsoleUI consoleUI;


    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description ="Sorting members by age" ;
    }

    public void execute(){
        getConsoleUI().sortByName();
    }

    public String getDescription() {
        return description;
    }
}
