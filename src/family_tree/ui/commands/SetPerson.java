package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class SetPerson extends Command {
    public SetPerson(ConsoleView consoleView) {
        super(consoleView);
        description = "Человек";
    }

    @Override
    public void execute(String data) {
        consoleView.addPersonToTree(data);
    }

}

