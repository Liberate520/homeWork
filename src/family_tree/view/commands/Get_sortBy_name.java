package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Get_sortBy_name extends Command{

    public Get_sortBy_name(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сортировка по имени (Фамилия Имя Отчество );";
    }
    public void execute() {
        consoleUI.treeInfo_sortByName();
    }
}
