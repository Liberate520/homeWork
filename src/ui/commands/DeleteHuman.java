package ui.commands;

import ui.Console;

public class DeleteHuman extends Command{
    public DeleteHuman(Console console) {
        super(console);
        description = "Удалить человека";
    }

    @Override
    public void execute() {
        console.deleteHuman();
    }
}