package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddChildren extends Command{

    public AddChildren(ConsoleUI console) {
        super(console);
        description = "Добавить ребенка";
    }

    public void execute() {
        consoleUI.addChild();
    }
}
