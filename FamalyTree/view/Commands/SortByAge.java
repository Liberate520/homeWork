package homeWork.FamalyTree.view.Commands;

import homeWork.FamalyTree.view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сортировка по возрасту";
    }    

    public void execute(){
        consoleUI.sortByAge();
    }
}
