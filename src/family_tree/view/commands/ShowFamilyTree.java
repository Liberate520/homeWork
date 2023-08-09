package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class ShowFamilyTree extends Command {
    public ShowFamilyTree(ConsoleUI console) {
        super("Показать семейное древо", console);
    }

    public void execute() {
        getConsole().showFamilyTree();
    }
}
