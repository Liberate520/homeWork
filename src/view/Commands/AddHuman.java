package view.Commands;

import view.ConsoleUI;

public class AddHuman extends Command {
    

    public AddHuman(ConsoleUI consoleUI){
        super("Добавить человека",consoleUI);
      
    }

    @Override
    public void execute(){
        super.consoleUI.addHuman();
    }   
}
