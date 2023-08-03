package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public class AddChildren extends Command {


    public AddChildren(ConsoleUI consoleUI){
        super(" Add new children.",consoleUI);
    }

    public void execut(){
        getConsoleUI().addChildren();
    }

}