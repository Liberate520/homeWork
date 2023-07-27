package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class GetTree extends Command{

    public GetTree(ConsoleView consoleView) {
        super(consoleView);
        description = "Вывести дерево подробно";
    }

    @Override
    public void execute(String text) {
        consoleView.printTree();
    }
}
