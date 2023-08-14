package family_tree.view.commands.show;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class ShowParents extends Command{
    public ShowParents(ConsoleUI consoleUi) {
        super(consoleUi, "Показать родителей.");
    }

    @Override
    public void execute() {
        super.consoleUi.showParents();
    }
}
