package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public class AddSpouse extends Command {


    public AddSpouse(ConsoleUI consoleUI){
        super(" Add new spouse.",consoleUI);
    }

    public void execut(){
        getConsoleUI().addSposue();
    }

}