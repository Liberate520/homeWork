package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortByDateBirthReverse extends Command {

    public SortByDateBirthReverse(ConsoleView consoleView) {
        super(consoleView);
        description = "по дате рождения обратная";
    }

    @Override
    public void execute(String text) {
        consoleView.sortByDateBirthReverse();
    }
}
