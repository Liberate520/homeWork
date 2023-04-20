package ui.commands;

import ui.Console;

public class AddHuman extends Command{
    public AddHuman(Console console) {
        super(console);
        description = "Добавить человека";
    }

    @Override
    public void execute() {
        console.addHuman();
    }
}
