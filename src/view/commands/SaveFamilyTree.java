package view.commands;

import view.ConsoleUI;

public class SaveFamilyTree extends Command{
    public SaveFamilyTree(ConsoleUI consoleUI) {
        super("Сохранить семейное дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveFamilyTree();
    }
}
