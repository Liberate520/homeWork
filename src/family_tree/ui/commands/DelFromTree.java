package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class DelFromTree extends Command{
    String description;
    ConsoleView consoleView;

    public DelFromTree(ConsoleView consoleView) {
        super(consoleView);
        description = "Удалить из дерева";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.delFromTree();
    }
}
