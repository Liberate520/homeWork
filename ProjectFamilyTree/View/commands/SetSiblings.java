package homeWork.ProjectFamilyTree.View.commands;

import homeWork.ProjectFamilyTree.View.ConsoleUI;

public class SetSiblings extends Command{
    public SetSiblings(ConsoleUI consoleUI) {
        super("Установить родственные связи между братьями/сестрами", consoleUI);
    }
    @Override
    public void execute() {
        super.consoleUI.siblings();
    }
}
