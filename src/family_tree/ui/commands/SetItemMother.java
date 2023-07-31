package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetItemMother extends Command {

    public SetItemMother(ConsoleView consoleView) {
        super(consoleView);
        description = "Маму";
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setMother(itemIndex);
    }
}
