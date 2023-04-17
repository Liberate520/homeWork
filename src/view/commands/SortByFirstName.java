package view.commands;

import view.Console;

public class SortByFirstName extends Command {
    public SortByFirstName(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Сортировка по имени ";
    }

    @Override
    public void execute() {
        getConsole().sortByFirstName();
    }
}
