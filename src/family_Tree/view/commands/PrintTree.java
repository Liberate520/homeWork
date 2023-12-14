package family_Tree.view.commands;

import family_Tree.view.ConsoleUI;

public class PrintTree extends Command{
    public PrintTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать текущее семейное древо";
    }

    @Override
    public void execute() {
        consoleUI.printTree();
    }
}
