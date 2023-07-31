package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class Exit extends Command {

    public Exit(ConsoleView consoleView) {
        super(consoleView);
        description = "Выход";
    }

    @Override
    public void execute(String text) {
        consoleView.exit();
    }
}
