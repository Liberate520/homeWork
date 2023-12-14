package family_Tree.view.commands;

import family_Tree.view.ConsoleUI;

public class GenerateTree extends Command{
    public GenerateTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сгенерировать семейное древо";
    }

    @Override
    public void execute() {
        consoleUI.generateTree();
    }
}
