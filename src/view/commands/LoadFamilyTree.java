package view.commands;

import view.ConsoleUI;

public class LoadFamilyTree extends Command{
    public LoadFamilyTree(ConsoleUI consoleUI) {
        super("Загрузить семейное дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().loadFamilyTree();
    }
}
