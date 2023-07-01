package FamilyTree.view.commands;

import FamilyTree.view.ConsoleUI;

public class GetFamilyTreeInfo implements Command{
    private ConsoleUI consoleUI;

    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getCommandDescription() {
        return "Показать дерево";
    }

    @Override
    public void execute() {
        consoleUI.getFamilyTreeInfo();
    }
}
