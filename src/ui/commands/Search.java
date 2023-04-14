package ui.commands;

import ui.Console;

public class Search extends Command{
    public Search(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Поиск";
    }

    @Override
    public void execute() {
        getConsole().search();
    }
}
