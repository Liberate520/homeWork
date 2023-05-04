package ui.commands;

import ui.Console;

public class RemoveHuman implements Command {
    Console console;

    public RemoveHuman(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.removeHuman();
    }

    @Override
    public String getDescription() {
        return "Удалить человека из дерева";
    }

}


