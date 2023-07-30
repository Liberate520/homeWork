package view.commands;

import view.ConsoleUI;

public class SortByBirthDate extends Command {
    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI,"ќтсортировать семейный список по дате рождени€");
    }

    public void execute(){
        consoleUI.sortByBirthDate();
    }
}
