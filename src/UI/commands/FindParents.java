package src.UI.commands;

import src.UI.Console;

public class FindParents extends Command{

    public FindParents(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "List of Parents";
    }

    @Override
    public void execute() {
        getConsole().findParents();
    }
}
