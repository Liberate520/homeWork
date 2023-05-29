package ui.commands;

import ui.Console;

public class SortByName implements Command{
    private Console console;


    public SortByName(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Сортировать по имени";
    }

    @Override
    public void execute() {
        console.sortByName();
        console.getInfo();
    }
}
