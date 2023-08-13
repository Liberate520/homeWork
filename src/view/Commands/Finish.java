package view.Commands;

import view.ConsoleUI;

public class Finish extends Command {
    

    public Finish(ConsoleUI consoleUI){
        super("Завершить работу",consoleUI);
      
    }
    
    @Override
    public void execute(){
        
        super.consoleUI.finish();
    }   
}
