package view.commands;

import view.ConsoleUI;

public class SaveFamilyTree extends Command{
    public SaveFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить текущее семейное дерево";
    }

    public void execute(){
        consoleUI.saveFamilyTree();
    }
}
