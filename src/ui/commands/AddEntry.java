package ui.commands;

import ui.Console;

public class AddEntry extends Command {
    public AddEntry(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Add new family member";
    }

    @Override
    public void execute() {
        getConsole().addEntry();
    }
}
