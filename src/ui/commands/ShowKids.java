package ui.commands;

import ui.Console;

public class ShowKids implements Command {
    private Console console;

    public ShowKids(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Показать всех детей человека";
    }

    @Override
    public void execute() {
        console.showKids();
    }
}
