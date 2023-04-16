package view.commands;

import view.Console;

public class Search extends Command{
    public Search(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Поиск человека";
    }

    @Override
    public void execute() {
        getConsole().search();
    }
}
