package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class Save extends Command{

    public Save(ConsoleUI consoleUI){
        super("Save info", consoleUI);

    }
    @Override
    public void execute(){
        try {
            super.getConsoleUI().save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
