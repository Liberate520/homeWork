package ui.commands;

import ui.Console;

public class ListOfNames implements Command {
    private Console console;

    public ListOfNames(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Показать список имен в дереве";
    }

    @Override
    public void execute() {
        console.listOfNames();
    }
}
