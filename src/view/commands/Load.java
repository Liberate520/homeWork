package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class Load extends Command{

    public Load(ConsoleUI consoleUI){
        super("Load tree", consoleUI);

    }
    @Override
    public void execute(){
        try {
            super.getConsoleUI().load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}