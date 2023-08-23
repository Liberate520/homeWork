package family_tree.view.commands;

import family_tree.view.*;

public class SaveTree extends Command {

    public SaveTree(ConsoleUI consoleUI) {
        super(consoleUI, "Сохранить древо в файл");
    }

    @Override
    public void execute() {
        consoleUI.saveTree();
    }

}
