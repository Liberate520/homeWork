package ui.commands;

import ui.Console;

public class FindHumanByName implements Command {
    private Console console;

    public FindHumanByName(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Найти человека по имени";
    }

    @Override
    public void execute() {
        console.findHumanByName();
    }
}
