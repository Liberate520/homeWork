package view.commands;

import view.ConsoleUI;

public class SortByBirthDay extends Command{
    public SortByBirthDay(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по дате рождения и вывести";
    }

    @Override
    public void execute() {
        consoleUI.sortByBirthDay();
    }
}
