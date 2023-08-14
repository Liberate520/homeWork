package View.Commands;

import java.io.Console;

import View.ConsoleUI;

public class SetWedding extends Command {
    public SetWedding(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Set wedding";
    }

    public void execute(){
        consoleUI.setDivorse();
    }
}
