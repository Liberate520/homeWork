package ui.commands;

import ui.Console;

public class AddFather extends Command{
    public AddFather (Console console) {
        super(console);
        description = "Добавить отца";
    }

    @Override
    public void execute() {
        console.addFather();
    }
}