package ui.commands;

import ui.Console;

public class SortBirthdate extends Command {
    public SortBirthdate(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сортировать по дате рождения.";
    }

    @Override
    public void execute() {
        getConsole().sortBirthdate();
    }
}
