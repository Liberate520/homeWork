package ui.commands.components;

import ui.Console;
import ui.commands.Command;

public class SavingChanges extends Command {

    public SavingChanges(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Save changes;";
    }

    @Override
    public void execute() {
        getConsole().save();
    }

}