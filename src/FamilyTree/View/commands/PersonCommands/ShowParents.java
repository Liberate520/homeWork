package FamilyTree.View.commands.PersonCommands;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

public class ShowParents extends Command {

    public ShowParents (ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать родителей";
    }

    public void execute(){
        consoleUI.ShowParents();
    }
}
