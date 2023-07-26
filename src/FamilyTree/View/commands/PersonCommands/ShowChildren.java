package FamilyTree.View.commands.PersonCommands;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

public class ShowChildren extends Command {

    public ShowChildren (ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать детей";
    }

    public void execute(){
        consoleUI.showChildren();
    }
}
