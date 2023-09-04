package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddParents extends Command{
    public AddParents(ConsoleUI console) {
        super(console);
        description = "Добавить родителя";
    }

    public void execute() {
        consoleUI.addParent();
    }
}
