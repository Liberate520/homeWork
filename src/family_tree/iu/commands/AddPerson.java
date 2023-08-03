package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class AddPerson extends Command{

    public AddPerson(ConsoleUI consoleUI){
        super("TODO: Add new person",consoleUI);
    }

    public void execute(){
        getConsoleUI().addPerson();
    }
}
