package view.commands;

import view.ConsoleUI;

public class CreateFamilyTree extends Command{
    public CreateFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создать новое семейное дерево";
    }
    @Override
    public void execute() {
        consoleUI.createFamilyTree();
    }
}
