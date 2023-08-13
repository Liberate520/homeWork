package view.Commands;

import view.ConsoleUI;

public class AddKinship extends Command {
    

    public AddKinship(ConsoleUI consoleUI){
        super("Установить родство",consoleUI);
      
    }
    
    @Override
    public void execute(){
        super.consoleUI.addKinship();
    }   
}
