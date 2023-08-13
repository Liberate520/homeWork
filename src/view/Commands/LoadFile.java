package view.Commands;

import view.ConsoleUI;

public class LoadFile extends Command {
    

    public LoadFile(ConsoleUI consoleUI){
        super("Загрузить данные",consoleUI);
      
    }
    
    @Override
    public void execute(){
        super.consoleUI.LoadFile();
        
    }   
}
