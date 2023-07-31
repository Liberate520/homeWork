package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class DelTree extends Command{

    public DelTree(ConsoleView consoleView) {
        super(consoleView);
        description = "Очистить дерево";
    }

    @Override
    public void execute(String text) {
        consoleView.delTree();
    }
}
