package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class SetMother extends Command {
    public SetMother(ConsoleUI consoleUI) {
        super("Set mother", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setMother();
    }
}