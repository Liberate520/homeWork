package View.Commands;

import View.ConsoleUI;

public class GetInfo extends Command{
    public GetInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Get info";
    }

    public void execute(){
        consoleUI.getInfo();
    }
}
