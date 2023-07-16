package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Print_treeInfo extends Command{


    public Print_treeInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Вывод на экран всего древа;";
    }
    public void execute() {
//        String sort_by = menu_1.get_choice();
        consoleUI.treeInfo_sortByID();
    }
}
