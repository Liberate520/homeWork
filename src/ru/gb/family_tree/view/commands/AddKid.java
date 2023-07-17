package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;

public class AddKid extends Command {

    public AddKid (ConsoleView consoleView) {
        super(consoleView, "добавить ребенка");
    }
    @Override
    public void execute() {
        consoleView.addKid();
    }
}