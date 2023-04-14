package ui.commands;

import ui.Console;

public class SortByGender extends Command{
    public SortByGender(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Sort Targarien by gender.";
    }

    @Override
    public void execute() {
        getConsole().sortByGender();
    }
}
