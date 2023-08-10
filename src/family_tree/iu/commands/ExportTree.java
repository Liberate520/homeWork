package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class ExportTree extends Command{

    public ExportTree(ConsoleUI consoleUI){
        super("TODO: Export Tree (JSON)",consoleUI);
    }

    public void execute(){
        getConsoleUI().exportTree();
    }
}
