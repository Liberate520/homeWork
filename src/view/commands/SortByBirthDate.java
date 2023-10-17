package view.commands;

import view.ConsoleUI;

public class SortByBirthDate extends Command{
    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по дате рождения";
    }

    public void execute(){
        consoleUI.sortByBirthDate();
    }
}
