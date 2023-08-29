package View.Commands;

import java.io.Console;

import View.ConsoleUI;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Add human";
    }

    public void execute(){
        consoleUI.addHuman();
    }
}
