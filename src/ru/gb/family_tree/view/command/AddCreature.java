package ru.gb.family_tree.view.command;

import view.ConsoleUI;

public class AddCreature extends Command {
    public AddCreature(ConsoleUI consoleUI) {
        super("Добавить человека", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addCreature();
    }
}
