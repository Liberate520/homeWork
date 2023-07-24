package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class GetTreePeaks extends Command{
    String description;
    ConsoleView consoleView;

    public GetTreePeaks(ConsoleView consoleView) {
        super(consoleView);
        description = "\"Главы\" дерева";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.printTreePeak();
    }
}
