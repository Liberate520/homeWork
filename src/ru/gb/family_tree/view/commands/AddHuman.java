package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddHuman extends Command {

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI, "добавить новый объект");
    }

    @Override
    public void execute() {
        consoleUI.addHuman();
    }
}