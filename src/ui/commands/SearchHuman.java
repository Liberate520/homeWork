package ui.commands;

import ui.Console;

public class SearchHuman extends Command {
    public SearchHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Поиск по фамилии";
    }

    @Override
    public void execute() {getConsole().searchHuman();
    }
}