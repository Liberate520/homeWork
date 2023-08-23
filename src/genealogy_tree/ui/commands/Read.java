package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public class Read extends Command {


    public Read(ConsoleUI consoleUI){
        super(" Read file.",consoleUI);
    }

    public void execute(){
        getConsoleUI().readFile();
    }

}