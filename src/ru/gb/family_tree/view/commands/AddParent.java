package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddParent extends Command {

    public AddParent(ConsoleUI consoleUI) {
        super(consoleUI, "добавить родителя");
    }

    @Override
    public void execute() {
        consoleUI.addParent();
    }
}