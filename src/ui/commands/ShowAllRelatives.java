package ui.commands;

import ui.Console;

public class ShowAllRelatives implements Command {
    private Console console;

    public ShowAllRelatives(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Показать всех родственников";
    }

    @Override
    public void execute() {
        console.showAllRelatives();
    }
}
