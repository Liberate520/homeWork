package classes.view.commands;

import classes.view.ConsoleUI;

public class SortById extends Command {
    public SortById(ConsoleUI consoleUI) {
        super(consoleUI);
        String description = "Отсортировать список по ID";
    }

    public void execute() {
        consoleUI.sortById();
    }
}
