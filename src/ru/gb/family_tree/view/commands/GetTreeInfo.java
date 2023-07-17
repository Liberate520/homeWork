package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.servise.FileHandler;
import ru.gb.family_tree.view.ConsoleView;

public class GetTreeInfo extends Command {

    public GetTreeInfo(ConsoleView consoleView) {
        super(consoleView, "вывести дерево в консоль");

    }
    @Override
    public void execute() {
        consoleView.getTreeInfo();
    }
}
