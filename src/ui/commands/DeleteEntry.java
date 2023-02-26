package ui.commands;

import ui.Console;

public class DeleteEntry extends Command {
    public DeleteEntry(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Delete family member";
    }

    @Override
    public void execute() {
        super.getConsole().deleteEntry();
    }
}