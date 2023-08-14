package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Finish  extends Command{
    public Finish(ConsoleUI consoleUi) {
        super(consoleUi, "Выход.");
    }

    @Override
    public void execute() {
        super.consoleUi.finish();
    }
}
