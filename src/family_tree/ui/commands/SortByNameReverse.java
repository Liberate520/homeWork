package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortByNameReverse extends Command {

    public SortByNameReverse(ConsoleView consoleView) {
        super(consoleView);
        description = "по имени - обратная";
    }

    @Override
    public void execute(String text) {
        consoleView.sortByNameReverse();
    }
}
