package view.commands;

import view.ConsoleUI;

public class GetFamilyInfo extends  Command{

    public GetFamilyInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить родословную";
    }

    public void execute(){
        consoleUI.getFamilyInfo();
    }
}
