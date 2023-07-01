package FamilyTree.view.commands;

import FamilyTree.view.ConsoleUI;

public class LoadTree implements Command {
    private ConsoleUI consoleUI;

    public LoadTree(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getCommandDescription() {
        return "Загрузить дерево из файла";
    }

    @Override
    public void execute() {
        consoleUI.loadTree();
    }
}
