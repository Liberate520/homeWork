package family_tree.view.commands.add.kinship;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class AddParents extends Command{

    public AddParents(ConsoleUI consoleUi) {
        super(consoleUi, "Детей");
    }

    @Override
    public void execute() {
        super.consoleUi.addKinship("CHILDREN");
    }
}
