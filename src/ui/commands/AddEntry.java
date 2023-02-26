package ui.commands;

import ui.Console;

public class AddHuman extends Command {
    public AddHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Add new family member";
    }

    @Override
    public void execute() {
        super.getConsole().addEntry();
    }
}
