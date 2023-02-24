package ui.commands;

import ui.Console;

public class AddNote extends Command {
    public AddNote(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Add new entry";
    }

    @Override
    public void execute() {
        getConsole().addNote();
    }
}
