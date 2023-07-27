package family_tree.view.consoleUI.menu.mainMenu;

import family_tree.view.consoleUI.ConsoleUi;
import family_tree.view.consoleUI.menu.Command;

public class ReadTree extends Command {
    public ReadTree(ConsoleUi consoleUi) {
        super("Read tree.", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().readTreeFromFile();
        getConsoleUi().getMenu().openMenuWorkWithTree();
        getConsoleUi().finishMainMenu();
    }
}
