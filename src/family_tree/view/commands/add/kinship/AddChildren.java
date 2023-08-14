package family_tree.view.commands.add.kinship;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class AddChildren extends Command{
    
    public AddChildren(ConsoleUI consoleUi) {
        super(consoleUi, "Родителей.");
    }

    @Override
    public void execute() {
        super.consoleUi.addKinship("PARENTS");
    }
}
