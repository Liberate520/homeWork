package ui.comands;

import ui.ConsoleUI;

public class RemoveNote extends Command{

    public RemoveNote(ConsoleUI console) {
        super(console);
    }

    @Override
    public String description() {
        return "Удалить заметку";
    }

    public void execute() {
        getConsole().removeNote();
    }
}
