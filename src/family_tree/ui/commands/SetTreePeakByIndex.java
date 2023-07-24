package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class SetTreePeakByIndex extends Command{
    String description;
    ConsoleView consoleView;

    public SetTreePeakByIndex(ConsoleView consoleView) {
        super(consoleView);
        description = "Установить \"главу\" дерева";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.setTreePeak();
    }
}
