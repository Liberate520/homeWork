package family_tree.view.consoleUI.menu.mainMenu;

import family_tree.view.consoleUI.ConsoleUi;
import family_tree.view.consoleUI.menu.Command;

public class CreateNewTree extends Command {
    public CreateNewTree(ConsoleUi consoleUi) {
        super("Create new tree.", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().getMenu().openMenuChooseType();
        getConsoleUi().finishMainMenu();
    }
}
