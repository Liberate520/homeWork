package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetItemDateBirth extends Command {

    public SetItemDateBirth(ConsoleView consoleView) {
        super(consoleView);
        description = "Дата рождения в формате YYYY M D";
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setDateBirth(itemIndex);
    }
}
