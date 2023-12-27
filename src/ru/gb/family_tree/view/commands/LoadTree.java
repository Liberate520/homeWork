package ru.gb.family_tree.view.commands;

public class LoadTree extends Command {

    public LoadTree(ConsoleUI consoleUI) {
        super("Загрузить сохраненное дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().loadTree();
    }
}
