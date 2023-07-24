package family_tree.ui.commands.change_item_parameter;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class ChangeItemParameter extends Command {
    String description;
    ConsoleView consoleView;

    public ChangeItemParameter(ConsoleView consoleView) {
        super(consoleView);
        description = "Изменить данные";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.changeItemParameter();
    }
}
