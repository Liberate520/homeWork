package ui.commands.components;

import ui.Console;
import ui.commands.Command;

public class SearchByName extends Command {

    public SearchByName(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Search by name;";
    }

    @Override
    public void execute() {
        getConsole().searchByName();
    }
    
}
