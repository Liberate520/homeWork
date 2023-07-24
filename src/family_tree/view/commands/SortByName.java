package family_tree.view.commands;

import family_tree.view.ConsoleUi;

public class SortByName extends Command{
    public SortByName(ConsoleUi consoleUi){
        super(consoleUi, ": Сортировать по имени");
    }
    public void execute(){
        consoleUi.sortByName();
    }
}
