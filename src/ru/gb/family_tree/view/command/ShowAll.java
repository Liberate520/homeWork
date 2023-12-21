package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class ShowAll extends Command{

    public ShowAll(ConsoleUI consoleUI) {
        super("Show all added people", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showAll();
    }
}
