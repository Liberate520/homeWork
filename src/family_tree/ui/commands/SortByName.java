package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortByName extends Command {

    public SortByName(ConsoleView consoleView) {
        super(consoleView);
        description = "по имени";
    }

    @Override
    public void execute(String text) {
        consoleView.sortByName();
    }
}
