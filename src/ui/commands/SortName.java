package ui.commands;

import ui.Console;

public class SortName extends Command{
    public SortName(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сортировать по именам.";
    }

    @Override
    public void execute() {
        getConsole().sortName();
    }
}
