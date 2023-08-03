package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public class SortByName extends Command {


    public SortByName(ConsoleUI consoleUI){
        super(" Sort them by Name.",consoleUI);
    }

    public void execut(){
        getConsoleUI().sortByName();
    }
}