package view.Commands;

import view.ConsoleUI;

public class GetHumanListInfo extends Command {
    

    public GetHumanListInfo(ConsoleUI consoleUI){
        super("Получить список людей",consoleUI);
      
    }
    
    @Override
    public void execute(){
        super.consoleUI.getInfoHumans();
    } 
}  
