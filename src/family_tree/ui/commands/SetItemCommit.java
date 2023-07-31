package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetItemCommit extends Command {

    public SetItemCommit(ConsoleView consoleView) {
        super(consoleView);
        description = "Доп. информацию";
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setCommit(itemIndex);
    }
}
