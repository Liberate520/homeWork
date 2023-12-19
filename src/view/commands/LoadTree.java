package view.commands;

import view.ConsoleUI;

public class LoadTree extends Command{

    public LoadTree(ConsoleUI consoleUI) {
        super("Загрузить сохраненное дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().loadSaveTree();
    }
}
