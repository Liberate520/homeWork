package family_tree.ui.commands.change_item_parameter;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetItemDateEndlife extends Command {
    String description;
    ConsoleView consoleView;

    public SetItemDateEndlife(ConsoleView consoleView) {
        super(consoleView);
        description = "Дата смерти в формате YYYY M D";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setDateEndlife(itemIndex);
    }
}
