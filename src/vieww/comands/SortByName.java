package vieww.comands;

import vieww.ConsoleUI;

public class SortByName implements Command{
    private ConsoleUI console;

    public SortByName(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Sort by name";
    }

    public void execute(){
        console.sortByName();
    }
}