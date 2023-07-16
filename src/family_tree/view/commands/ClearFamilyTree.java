package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class ClearFamilyTree extends Command{

    public ClearFamilyTree(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Очистить древо;";
    }
    public void execute() {
        consoleUI.clearFamilyTree();
    }
}
