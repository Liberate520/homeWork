package family_tree.view.consoleUI.menu.mainMenu;

import family_tree.view.consoleUI.ConsoleUi;
import family_tree.view.consoleUI.menu.Command;

public class Finish extends Command {
    public Finish(ConsoleUi consoleUi) {
        super("Close.", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().finishMainMenu();
        getConsoleUi().finish();
    }
}
