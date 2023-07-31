package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class SetGenderMaleChange extends Command {
    public SetGenderMaleChange(ConsoleView consoleView) {
        super(consoleView);
        description = "Мужской";
    }

    @Override
    public void execute(String itemIndex) {
        consoleView.setGenderMaleChange(itemIndex);
    }
}
