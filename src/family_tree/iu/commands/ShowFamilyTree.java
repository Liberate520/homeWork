package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class ShowFamilyTree extends Command{

    public ShowFamilyTree(ConsoleUI consoleUI){
        super("Show Family Tree (w/o marriage)",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showTree();
    }
}
