package ui.commands;

import ui.Console;

public class AddHuman implements Command{
    private Console console;

    public AddHuman(Console console){
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
        console.addHuman();
    }
}
