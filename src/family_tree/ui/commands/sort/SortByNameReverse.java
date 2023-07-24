package family_tree.ui.commands.sort;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortByNameReverse extends Command {
    String description;
    ConsoleView consoleView;

    public SortByNameReverse(ConsoleView consoleView) {
        super(consoleView);
        description = "Добавить в дерево";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.sortByNameReverse();
    }
}
