package ui.commands;

import ui.Console;

public class SortByAge implements Command {
    private Console console;

    public SortByAge(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Сортировать по возрасту";
    }

    @Override
    public void execute() {
        console.sortByAge();
        console.getInfo();
    }
}
