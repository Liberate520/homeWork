package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class SetDeathDate extends Command {
    public SetDeathDate(ConsoleUI consoleUI) {
        super("Set deathday", consoleUI);
    }

    @Override
    public void execute() { getConsoleUI().setDeathDate();
    }
}