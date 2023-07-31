package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortByAge extends Command {

    public SortByAge(ConsoleView consoleView) {
        super(consoleView);
        description = "по возрасту";
    }

    @Override
    public void execute(String text) {
        consoleView.sortByAge();
    }
}
