package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class DelFromTree extends Command{

    public DelFromTree(ConsoleView consoleView) {
        super(consoleView);
        description = "Удалить из дерева";
    }

    @Override
    public void execute(String text) {
        consoleView.delFromTree();
    }
}
