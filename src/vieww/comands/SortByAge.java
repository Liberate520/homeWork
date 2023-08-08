package vieww.comands;

import vieww.ConsoleUI;

public class SortByAge implements Command {
    private ConsoleUI console;

    public SortByAge(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Sort tree by age";
    }

    public void execute(){
        console.sortByAge();
    }
}