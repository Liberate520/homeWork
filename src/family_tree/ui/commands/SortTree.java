package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortTree extends Command {

    public SortTree(ConsoleView consoleView) {
        super(consoleView);
        description = "Отсортировать дерево";
    }

    @Override
    public void execute(String text) {
        consoleView.sortTree();
    }
}
