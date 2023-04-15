package ui.comands;

import ui.Console;

public class DeleteNote extends Command {

    public DeleteNote(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Удалить запись";
    }

    @Override
    public boolean execute() {
        System.out.println("Удаляю...");
        return false;
    }
}
