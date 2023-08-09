package view.commands;

import view.ConsoleUI;

public class SortByAge extends Command{
    private String description;
    private ConsoleUI consoleUI;


    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sorting members by age";
    }

    public void execute(){
        getConsoleUI().sortByAge();
    }

    public String getDescription(){
        return description;
    }
}
