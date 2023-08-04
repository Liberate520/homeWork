package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public class AddHuman extends Command {


    public AddHuman(ConsoleUI consoleUI){
        super(" Add new human.",consoleUI);
    }

    public void execute(){
        getConsoleUI().addHuman();
    }

}
