package family_tree.ui.commands.change_item_parameter;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetGenderFemale extends Command {
    String description;
    ConsoleView consoleView;

    public SetGenderFemale(ConsoleView consoleView) {
        super(consoleView);
        description = "Женский п.";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.setGenderFemaleForAdd(text);
    }
}
