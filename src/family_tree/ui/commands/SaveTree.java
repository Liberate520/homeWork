package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class SaveTree extends Command{
    String description;
    ConsoleView consoleView;

    public SaveTree(ConsoleView consoleView) {
        super(consoleView);
        description = "Сохранить в файл";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.saveTree();
    }
}
