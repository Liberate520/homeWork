package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class ShowPersonTree  extends Command {

    public ShowPersonTree(ConsoleUI consoleUI){
        super("Show Personal Tree (use Person ID)",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showPersonTree();
    }
}
