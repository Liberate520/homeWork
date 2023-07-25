package classes.view.commands;

import classes.view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        String description = "Отсортировать список по имени";
    }

    public void execute(){
        consoleUI.sortByName();
    }
}
