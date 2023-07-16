package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddMember extends Command {

    public AddMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавление члена в дерево";
    }

    @Override
    public void execute() { consoleUI.addMember(); }
}
