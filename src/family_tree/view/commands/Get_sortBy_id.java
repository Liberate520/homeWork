package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Get_sortBy_id extends Command{

    public Get_sortBy_id(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сортировка по Id;";
    }
    public void execute() {
        consoleUI.treeInfo_sortByID();
    }
}
