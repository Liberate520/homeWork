package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class LoadTree extends Command{
    String description;
    ConsoleView consoleView;

    public LoadTree(ConsoleView consoleView) {
        super(consoleView);
        description = "Загрузить из файла";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.loadTree();
    }
}
