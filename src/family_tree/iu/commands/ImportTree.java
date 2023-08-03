package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class ImportTree  extends Command{

    public ImportTree(ConsoleUI consoleUI){
        super("TODO: Import Tree (JSON)",consoleUI);
    }

    public void execute(){
        getConsoleUI().importTree();
    }
}
