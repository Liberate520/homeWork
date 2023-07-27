package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortByChildrenReverse extends Command {

    public SortByChildrenReverse(ConsoleView consoleView) {
        super(consoleView);
        description = "по количеству детей обратная";
    }

    @Override
    public void execute(String text) {
        consoleView.sortByChildrenReverse();
    }
}
