package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class Exit extends Command {
    String description;
    ConsoleView consoleView;

    public Exit(ConsoleView consoleView) {
        super(consoleView);
        description = "Выход";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.exit();
    }
}
