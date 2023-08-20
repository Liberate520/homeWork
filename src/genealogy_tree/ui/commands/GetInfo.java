package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public class GetInfo extends Command {


    public GetInfo(ConsoleUI consoleUI){
        super(" Display family trees.",consoleUI);
    }

    public void execute(){
        getConsoleUI().getInfo();
    }
    }