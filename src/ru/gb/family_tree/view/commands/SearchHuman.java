package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;

import java.io.IOException;

public class SearchHuman  extends Command {
    public SearchHuman(ConsoleView consoleView) {
        super(consoleView, "поиск (по фамилии или по имени или по номеру паспорта)");
    }

    @Override
    public void execute() {consoleView.searchHuman();}
}