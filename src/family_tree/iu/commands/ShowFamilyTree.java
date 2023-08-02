package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class ShowFamilyTree extends Command{

    public ShowFamilyTree(ConsoleUI consoleUI){
        super("Show FamilyTree",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showTree();
    }
}
