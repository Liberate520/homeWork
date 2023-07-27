package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetItemGender extends Command {

    public SetItemGender(ConsoleView consoleView) {
        super(consoleView);
        description = "Пол";
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setGenderChange(itemIndex);
    }
}
