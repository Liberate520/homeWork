package ui.commands;

import ui.ConsoleUI;

public class SearchMember extends Command{
    public SearchMember(ConsoleUI console) {
        super(console);
        description = "Поиск элемента дерева";
    }

    @Override
    public void execute() {
        console.searchMember();
    }
}
