package family_tree.view.consoleUI.menu.menuWorkWithTree;

import family_tree.view.consoleUI.ConsoleUi;
import family_tree.view.consoleUI.menu.Command;

public class SaveTree extends Command {
    public SaveTree(ConsoleUi consoleUi) {
        super("Save tree.", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().saveTree();
    }
}
