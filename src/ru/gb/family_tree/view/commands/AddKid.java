package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddKid extends Command {

    public AddKid (ConsoleUI consoleUI) {
        super(consoleUI, "добавить ребенка");
    }
    @Override
    public void execute() {
        consoleUI.addKid();
    }
}