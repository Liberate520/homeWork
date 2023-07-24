package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class GetTreeShort extends Command{
    String description;
    ConsoleView consoleView;

    public GetTreeShort(ConsoleView consoleView) {
        super(consoleView);
        description = "Вывести дерево коротко";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.printTreeShort();
    }
}
