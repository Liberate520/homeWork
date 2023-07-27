package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class SetGenderFemaleChange extends Command {
    public SetGenderFemaleChange(ConsoleView consoleView) {
        super(consoleView);
        description = "Женский";
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setGenderFemaleChange(itemIndex);
    }
}
