package ui.commands;

import ui.Console;

public class SortByName extends Command{
    public SortByName(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Sort Targarien by name.";
    }

    @Override
    public void execute() {
        getConsole().sortByName();
    }
}
