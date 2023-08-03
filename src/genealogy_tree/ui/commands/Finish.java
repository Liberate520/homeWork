package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public class Finish extends Command {


    public Finish(ConsoleUI consoleUI){
        super(" Finish work.",consoleUI);
    }

    public void execut(){
        getConsoleUI().finish();
    }
}