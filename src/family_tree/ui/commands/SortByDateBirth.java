package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortByDateBirth extends Command {

    public SortByDateBirth(ConsoleView consoleView) {
        super(consoleView);
        description = "по дате рождения";
    }

    @Override
    public void execute(String text) {
        consoleView.sortByDateBirth();
    }
}
