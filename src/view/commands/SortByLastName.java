package view.commands;

import view.Console;

public class SortByLastName extends Command {
    public SortByLastName(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Сортировка по фамилии ";
    }

    @Override
    public void execute() {
        getConsole().sortByLastName();
    }
}
