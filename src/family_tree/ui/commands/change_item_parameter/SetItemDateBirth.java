package family_tree.ui.commands.change_item_parameter;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetItemDateBirth extends Command {
    String description;
    ConsoleView consoleView;

    public SetItemDateBirth(ConsoleView consoleView) {
        super(consoleView);
        description = "Дата рождения в формате YYYY M D";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setDateBirth(itemIndex);
    }
}
