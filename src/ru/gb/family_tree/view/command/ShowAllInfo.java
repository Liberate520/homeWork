package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class ShowAllInfo extends Command{
    public ShowAllInfo(ConsoleUI consoleUI) {
        super("Show all people info", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().ShowAllInfo();
    }
}