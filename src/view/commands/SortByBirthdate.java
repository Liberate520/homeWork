package view.commands;

import view.Console;

public class SortByBirthdate extends Command {

    public SortByBirthdate(Console console) {
        super(console);
        description = "Сортировка по дате рождения";
    }

    @Override
    public void execute() {
        console.sortByBirthdate();
    }
}
