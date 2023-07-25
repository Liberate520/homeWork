package classes.view.commands;

import classes.view.ConsoleUI;

public class SortByBrithDate extends Command {
    public SortByBrithDate(ConsoleUI consoleUI) {
        super(consoleUI);
        String description = "Отсортировать список по возрасту";
    }

    public void execute(){
        consoleUI.SortByBrithDate();
    }
}
