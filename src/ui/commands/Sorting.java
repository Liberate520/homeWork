package ui.commands;

import ui.Console;

public class Sorting extends Command{
    public Sorting(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сортировка";
    }

    @Override
    public void execute() {
        getConsole().sorting();
    }
}