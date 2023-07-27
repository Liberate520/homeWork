package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class GetTreeShort extends Command{

    public GetTreeShort(ConsoleView consoleView) {
        super(consoleView);
        description = "Вывести дерево коротко";
    }

    @Override
    public void execute(String text) {
        consoleView.printTreeShort();
    }
}
