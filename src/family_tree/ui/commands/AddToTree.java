package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class AddToTree extends Command{
//    String description;
//    ConsoleView consoleView;

    public AddToTree(ConsoleView consoleView) {
        super(consoleView);
        description = "Добавить в дерево";
    }

//    @Override
//    public String getDescription() {
//        return super.getDescription();
//    }

    @Override
    public void execute(String text) {
        consoleView.addToTree();
    }
}
