package family_tree.ui.commands;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SetGenderFemale extends Command {

    public SetGenderFemale(ConsoleView consoleView) {
        super(consoleView);
        description = "Женский п.";
    }

    @Override
    public void execute(String text) {
        consoleView.setGenderFemaleForAdd(text);
    }
}
