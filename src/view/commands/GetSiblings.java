package view.commands;

import view.ConsoleUI;

public class GetSiblings extends Command{

    public GetSiblings(ConsoleUI consoleUI){
        super("Get siblings", consoleUI);

    }
    @Override
    public void execute(){
        super.getConsoleUI().getSiblings();
    }
}
