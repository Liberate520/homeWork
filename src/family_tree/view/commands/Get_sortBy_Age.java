package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Get_sortBy_Age extends Command{

    public Get_sortBy_Age(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сортировка по дате рождения;";
    }
    public void execute() {
        consoleUI.treeInfo_sortByAge();
    }
}
