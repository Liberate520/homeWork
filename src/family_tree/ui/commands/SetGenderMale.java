package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetGenderMale extends Command {

    public SetGenderMale(ConsoleView consoleView) {
        super(consoleView);
        description = "Мужской п.";
    }

    @Override
    public void execute(String text) {
        consoleView.setGenderMaleForAdd(text);
    }
}
