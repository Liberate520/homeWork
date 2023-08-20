package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public class SetDivorce extends Command {


    public SetDivorce(ConsoleUI consoleUI){
        super(" Divorce two person.",consoleUI);
    }

    public void execute(){
        getConsoleUI().setDivorce();
    }

}