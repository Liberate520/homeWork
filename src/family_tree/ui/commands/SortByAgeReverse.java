package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortByAgeReverse extends Command {

    public SortByAgeReverse(ConsoleView consoleView) {
        super(consoleView);
        description = "по возрасту обратная";
    }

    @Override
    public void execute(String text) {
        consoleView.sortByAgeReverse();
    }
}
