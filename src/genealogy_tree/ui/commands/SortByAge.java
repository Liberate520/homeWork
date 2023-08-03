package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public class SortByAge extends Command {


    public SortByAge(ConsoleUI consoleUI){
        super(" Sort them by age of people.",consoleUI);
    }

    public void execut(){
        getConsoleUI().sortByAge();
    }
}