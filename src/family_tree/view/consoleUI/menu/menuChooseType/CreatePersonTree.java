package family_tree.view.consoleUI.menu.menuChooseType;

import family_tree.view.consoleUI.ConsoleUi;
import family_tree.view.consoleUI.menu.Command;

public class CreatePersonTree extends Command {

    public CreatePersonTree(ConsoleUi consoleUi) {
        super("Create tree of Persons.", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().createTreeOfPerson();
        getConsoleUi().getMenu().openMenuWorkWithTree();
    }
}
