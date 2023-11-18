package view.commands;

import view.ConsoleUI;

public class SortByBirthDay extends Commands {
    public SortByBirthDay(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по дате рождения";
    }

    public void execute(){
        consoleUI.sortByBirthDay();
    }
}
