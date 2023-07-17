package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;

public class AddParent extends Command {

    public AddParent (ConsoleView consoleView) {
        super(consoleView, "добавить родителя");
    }
    @Override
    public void execute() {
        consoleView.addParent();
    }
}

