package familyTree.View.Commands;

import familyTree.View.ConsoleUI;

public class Restore extends Command{
    public Restore(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить дерево из файла";
    }

    @Override
    public void execute() {
        consoleUI.restoreTree();
    }
}
