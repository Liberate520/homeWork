package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetTreeInfo extends Command {

    public GetTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI, "вывести дерево в консоль");

    }

    @Override
    public void execute() {
        consoleUI.getTreeInfo();
    }
}