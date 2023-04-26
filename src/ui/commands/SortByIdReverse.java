package ui.commands;

import ui.Console;

public class SortByIdReverse extends Command{
    public SortByIdReverse(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Sort Targarien by ID, but reversed.";
    }

    @Override
    public void execute() {
        getConsole().sortByIdReverse();
    }
}
