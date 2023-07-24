package family_tree.ui.commands.sort;

import family_tree.ui.ConsoleView;
import family_tree.ui.commands.Command;

public class SortByAge extends Command {
    String description;
    ConsoleView consoleView;

    public SortByAge(ConsoleView consoleView) {
        super(consoleView);
        description = "Добавить в дерево";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.sortByAge();
    }
}
