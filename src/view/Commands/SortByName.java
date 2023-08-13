package view.Commands;

import view.ConsoleUI;

public class SortByName extends Command {
    

    public SortByName(ConsoleUI consoleUI){
        super("Сортировка по имени",consoleUI);
      
    }
    
    @Override
    public void execute(){
        super.consoleUI.sortByName();
    }   
}
