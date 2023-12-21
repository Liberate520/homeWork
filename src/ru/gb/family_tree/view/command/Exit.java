package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class Exit extends Command {

    public Exit(ConsoleUI consoleUI) {
        super("Выход", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().setWork(false);
    }
}