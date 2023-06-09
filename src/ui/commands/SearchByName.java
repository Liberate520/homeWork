package ui.commands;

import ui.Console;

public class SearchByName implements Command {
    private Console console;

    public SearchByName(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Поиск по имени";
    }

    @Override
    public void execute() {
        console.serchByName();
    }
}
