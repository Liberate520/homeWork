package family_tree.view.consoleUI.menu.menuChooseType;

import family_tree.view.consoleUI.ConsoleUi;
import family_tree.view.consoleUI.menu.Command;

public class CreateDogsTree extends Command {
    public CreateDogsTree(String description, ConsoleUi consoleUi) {
        super("Create tree of Dogs", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().createTreeOfDog();
        getConsoleUi().getMenu().openMenuWorkWithTree();
    }
}
