package FamilyTree.view.commands;

import FamilyTree.view.ConsoleUI;

public class SaveTree implements Command{
    private ConsoleUI consoleUI;

    public SaveTree(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getCommandDescription() {
        return "Сохранить дерево";
    }

    @Override
    public void execute() {
        consoleUI.saveTree();
    }
}
