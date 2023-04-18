package view.commands;

import view.Console;

public class SearchHuman extends Command {
    public SearchHuman(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Поиск человека ";
    }

    @Override
    public void execute() {
        getConsole().searchHuman();
    }
}
