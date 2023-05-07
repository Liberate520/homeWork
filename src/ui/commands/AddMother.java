package ui.commands;

import ui.Console;

public class AddMother extends Command{
    public AddMother (Console console) {
        super(console);
        description = "Добавить мать";
    }

    @Override
    public void execute() {
        console.addMother();
    }
}