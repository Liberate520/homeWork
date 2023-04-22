package ui.commands;

import ui.Console;

public class SearchPersonDescendance extends Command {
    public SearchPersonDescendance(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Find Targarien descendance.";
    }

    @Override
    public void execute() {
        getConsole().searchPersonDescendance();
    }
}
