package View.Commands;

import View.ConsoleUI;

public class AddParents extends Command {
    public AddParents(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Add parents";
    }

    public void execute(){
        consoleUI.addParents();
    }
}
