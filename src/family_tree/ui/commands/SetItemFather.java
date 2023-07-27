package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetItemFather extends Command {

    public SetItemFather(ConsoleView consoleView) {
        super(consoleView);
        description = "Папу";
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setFather(itemIndex);
    }
}
