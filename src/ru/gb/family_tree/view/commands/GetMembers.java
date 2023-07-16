package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetMembers extends Command {

    public GetMembers(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список членов дерева";
    }

    @Override
    public void execute() { consoleUI.getMembers(); }
}
