package family_tree.view.consoleUI.menu.mainMenu;

import family_tree.view.consoleUI.ConsoleUi;
import family_tree.view.consoleUI.menu.Command;

public class ReadTreeOfPersonFromFile extends Command {
    public ReadTreeOfPersonFromFile(ConsoleUi consoleUi) {
        super("Read tree of person from file.", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().readTreeFromFile();
        getConsoleUi().getMenu().openMenuWorkWithTree();
        getConsoleUi().finishMainMenu();
    }
}
