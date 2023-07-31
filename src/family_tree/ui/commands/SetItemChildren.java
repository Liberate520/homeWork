package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetItemChildren extends Command {

    public SetItemChildren(ConsoleView consoleView) {
        super(consoleView);
        description = "Детей";
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setChildren(itemIndex);
    }
}
