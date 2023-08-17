package homeWork.ProjectFamilyTree.View.commands;

import homeWork.ProjectFamilyTree.View.ConsoleUI;

public class SetParentsAndChilds extends Command{
    public SetParentsAndChilds(ConsoleUI consoleUI) {
        super("Установить родство между ребенком и родителями", consoleUI);
    }
    @Override
    public void execute() {
        super.consoleUI.setParentsAndChilds();
    }
}
