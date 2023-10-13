package view.commands;

import view.ConsoleUI;

public class CreateCustomTree extends Command{
    public CreateCustomTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создать пример семейного дерева";
    }

    public void execute(){
        consoleUI.createCustomTree();
    }
}
