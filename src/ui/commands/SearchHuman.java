package ui.commands;

import ui.Console;

public class SearchHuman extends Command {
    public SearchHuman(Console console) {
        super(console);
        description = "Найти человека";
    }
    @Override
    public void execute() {
        console.searchHuman();
    }
}
