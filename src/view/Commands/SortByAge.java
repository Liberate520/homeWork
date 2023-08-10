package view.Commands;

import view.ConsoleUI;

public class SortByAge extends Command {
    

    public SortByAge(ConsoleUI consoleUI){
        super("Сортировка по возрасту",consoleUI);
      
    }
    
    @Override
    public void execute(){
        super.consoleUI.SortByAge();
    }   
}
