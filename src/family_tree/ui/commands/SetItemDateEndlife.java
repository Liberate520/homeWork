package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetItemDateEndlife extends Command {

    public SetItemDateEndlife(ConsoleView consoleView) {
        super(consoleView);
        description = "Дата смерти в формате YYYY M D";
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setDateEndlife(itemIndex);
    }
}
