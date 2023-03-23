package ui.commands;

import ui.Console;

public class PrintNotes extends Command {
    public PrintNotes(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Напечатать все заметки";
    }

    @Override
    public void execute()  {
        getConsole().printNotes();

    }

}
