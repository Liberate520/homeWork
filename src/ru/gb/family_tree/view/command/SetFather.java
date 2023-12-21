package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class SetFather extends Command {
    public SetFather(ConsoleUI consoleUI) {
        super("Set father", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setFather();
    }
}