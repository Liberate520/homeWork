package family_tree.ui.commands.change_item_parameter;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetGenderMale extends Command {
    String description;
    ConsoleView consoleView;

    public SetGenderMale(ConsoleView consoleView) {
        super(consoleView);
        description = "Мужской п.";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.setGenderMaleForAdd(text);
    }
}
