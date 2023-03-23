package ui.comands;

import ui.ConsoleUI;

public class AddNote extends Command{

    public AddNote(ConsoleUI console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить заметку";
    }

    public void execute() {
        getConsole().addNote();
    }
}
