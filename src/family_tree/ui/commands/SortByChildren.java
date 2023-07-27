package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortByChildren extends Command {

    public SortByChildren(ConsoleView consoleView) {
        super(consoleView);
        description = "по количеству детей";
    }

    @Override
    public void execute(String text) {
        consoleView.sortByChildren();
    }
}
