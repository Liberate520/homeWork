package family_tree.view.commands;

import family_tree.view.*;

public class LoadSampleTree extends Command {

    public LoadSampleTree(ConsoleUI consoleUI) {
        super(consoleUI, "Загрузить древо-образец");
    }

    @Override
    public void execute() {
        consoleUI.loadSampleTree();
    }

}
