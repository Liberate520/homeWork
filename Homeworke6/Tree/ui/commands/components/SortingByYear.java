package ui.commands.components;

import ui.Console;
import ui.commands.Command;

public class SortingByYear extends Command {

    public SortingByYear(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Sorting by year of birth;";
    }

    @Override
    public void execute() {
        getConsole().sortByAge();
    }
}