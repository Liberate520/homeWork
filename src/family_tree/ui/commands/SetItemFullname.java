package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetItemFullname extends Command {

    public SetItemFullname(ConsoleView consoleView) {
        super(consoleView);
        description = "ФИО";
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setFullname(itemIndex);
    }
}
