package ui.comands;

import ui.ConsoleUI;

public class ChangeNote extends Command{
    public ChangeNote(ConsoleUI console) {
        super(console);
    }

    @Override
    public String description() {
        return "Изменить заметку";
    }

    @Override
    public void execute() {
        getConsole().changeNote();
    }
}
