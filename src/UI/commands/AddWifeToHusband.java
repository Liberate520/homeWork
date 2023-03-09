package src.UI.commands;

import src.UI.Console;

public class AddWifeToHusband extends Command{
    public AddWifeToHusband(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Add a Wife to Husband";
    }

    @Override
    public void execute() {
        getConsole().addWifeToHusband();
    }
}