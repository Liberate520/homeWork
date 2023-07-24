package family_tree.ui.commands.sort;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortByChildrenReverse extends Command {
    String description;
    ConsoleView consoleView;

    public SortByChildrenReverse(ConsoleView consoleView) {
        super(consoleView);
        description = "Добавить в дерево";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.sortByChildrenReverse();
    }
}
