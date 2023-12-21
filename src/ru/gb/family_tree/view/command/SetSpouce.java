package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class SetSpouce extends Command{
    public SetSpouce(ConsoleUI consoleUI) {
        super("Set spouce", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setSpouce();
    }
}
