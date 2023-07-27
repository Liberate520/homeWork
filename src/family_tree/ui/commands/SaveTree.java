package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class SaveTree extends Command{

    public SaveTree(ConsoleView consoleView) {
        super(consoleView);
        description = "Сохранить в файл";
    }

    @Override
    public void execute(String text) {
        consoleView.saveTree();
    }
}
