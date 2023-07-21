package homeWork.FamalyTree.view.Commands;

import homeWork.FamalyTree.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сортировка по имени";
    }    

    public void execute(){
        consoleUI.sortByName();
    }
    
}
