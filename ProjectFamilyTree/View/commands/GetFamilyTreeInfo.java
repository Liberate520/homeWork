package homeWork.ProjectFamilyTree.View.commands;

import homeWork.ProjectFamilyTree.View.ConsoleUI;

public class GetFamilyTreeInfo extends Command{
    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super("Получить семейное древо", consoleUI);
    }

    @Override
    public void execute() {
        super.consoleUI.getFamilyTreeInfo();
    }
}
