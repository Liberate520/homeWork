package src.UI.commands;

import src.UI.Console;

public class FindSpouse extends Command{

    public FindSpouse(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "List of spouses";
    }

    @Override
    public void execute() {
        getConsole().findSpouse();
    }
}
