package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class SetDivorce extends Command{
    public SetDivorce(ConsoleUI consoleUI) {
        super("Divorce the spouses", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().SetDivorce();
    }
}