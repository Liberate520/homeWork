package view.commands;

import view.ConsoleUI;

public class GetFamilyTree extends Command{
    public GetFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить генеалогическое дерево человека.";
    }

    @Override
    public void execute() {
        consoleUI.getFamilyTree();
    }
}
