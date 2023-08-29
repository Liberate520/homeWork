package View.Commands;

import View.ConsoleUI;

public class SetDivorse extends Command{
    public SetDivorse(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Set divorse";
    }

    public void execute(){
        consoleUI.setDivorse();
    }
}
