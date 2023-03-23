package ui.commands;

import ui.Console;

public class DeleteNotes extends Command{
    public DeleteNotes(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Удаление заметки";
    }

    @Override
    public void execute(){
        getConsole().deleteNotes();
    }
}
