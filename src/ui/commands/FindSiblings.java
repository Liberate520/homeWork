package ui.commands;

import ui.Console;

public class FindSiblings implements Command {
    private Console console;

    public FindSiblings(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Найти братьев и сестер";
    }

    @Override
    public void execute() {
        console.findSiblings();
    }
}
