package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class GetTreePeaks extends Command{

    public GetTreePeaks(ConsoleView consoleView) {
        super(consoleView);
        description = "Текущие \"главы\" дерева:";
    }

    @Override
    public void execute(String text) {
        consoleView.printTreePeak();
    }
}
