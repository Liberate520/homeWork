package ui.commands;

import ui.Console;

public class AddNotes extends Command {

    public AddNotes(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить новую заметку";
    }

    @Override
    public void execute() {
        getConsole().addNotes();

    }
}
