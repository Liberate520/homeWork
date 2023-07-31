package family_tree.view.commands;

import family_tree.view.*;

public class LoadTree extends Command {

    public LoadTree(ConsoleUI consoleUI) {
        super(consoleUI, "Загрузить древо из файла");
    }

    @Override
    public void execute() {
        consoleUI.loadTree();
    }

}
