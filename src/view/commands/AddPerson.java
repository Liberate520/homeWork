package view.commands;

import view.ConsoleUI;

public class AddPerson extends Command{

    public AddPerson(ConsoleUI consoleUI){
        super("Add person", consoleUI);

    }
    @Override
    public void execute(){
        super.getConsoleUI().addPerson();
    }
}
