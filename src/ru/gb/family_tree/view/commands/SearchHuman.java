package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SearchHuman  extends Command {
    public SearchHuman(ConsoleUI consoleUI) {
        super(consoleUI, "поиск (по фамилии или по имени или по номеру паспорта)");
    }

    @Override
    public void execute() {
        consoleUI.searchHuman();}
}