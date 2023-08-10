package view.Commands;

import view.ConsoleUI;

public class DelHuman extends Command {
    

    public DelHuman(ConsoleUI consoleUI){
        super("Удалить человека",consoleUI);
      
    }
    
    @Override
    public void execute(){
        super.consoleUI.DelHuman();
    }   
}
