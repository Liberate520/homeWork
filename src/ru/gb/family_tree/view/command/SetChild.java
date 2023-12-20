package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class SetChild extends Command {
    public SetChild(ConsoleUI consoleUI) {
        super("Set child", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setChild();
    }
}
