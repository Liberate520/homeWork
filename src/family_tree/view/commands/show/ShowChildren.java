package family_tree.view.commands.show;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class ShowChildren extends Command{
    public ShowChildren(ConsoleUI consoleUi) {
        super(consoleUi, "Показать детей.");
    }

    @Override
    public void execute() {
        super.consoleUi.showChildren();
    }
}
