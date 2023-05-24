package ui.commands;

import ui.Console;

public class SortByName implements Command {
    private Console console;

    public SortByName(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Отсортировать список родственников по имени";
    }

    @Override
    public void execute() {
        console.sortByName();
    }
}
