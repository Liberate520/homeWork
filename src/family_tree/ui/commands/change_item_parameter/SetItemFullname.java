package family_tree.ui.commands.change_item_parameter;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetItemFullname extends Command {
    String description;
    ConsoleView consoleView;

    public SetItemFullname(ConsoleView consoleView) {
        super(consoleView);
        description = "ФИО";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setFullname(itemIndex);
    }
}
