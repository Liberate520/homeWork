package view.commands;

import view.Console;

public class DelNote extends Command {

    public DelNote(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Удалить объект";
    }

    @Override
    public void execute() {
        System.out.println("Удаляю...");
    }
}
