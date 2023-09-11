package view.commands;

import view.ConsoleUI;

public class Finis extends Command{

    public Finis(ConsoleUI consoleUI){
        super("Finish", consoleUI);

    }
    @Override
    public void execute(){
        super.getConsoleUI().finish();
    }
}
