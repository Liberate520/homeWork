package ui.commands;

import ui.Console;

public class SearchPerson extends Command{
    public SearchPerson(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Find Targarien.";
    }

    @Override
    public void execute() {
        getConsole().searchPerson();
    }
}
