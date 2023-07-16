package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SaveFamilyTree extends Command{

    public SaveFamilyTree(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сохранить семейное древо в файл;";
    }
    public void execute() {
        consoleUI.saveFamilyTree();
    }
}
