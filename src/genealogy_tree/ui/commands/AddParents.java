package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public class AddParents extends Command {


    public AddParents(ConsoleUI consoleUI){
        super(" Add new parents.",consoleUI);
    }

    public void execute(){
        getConsoleUI().addParents();
    }

}