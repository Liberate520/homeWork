package FamilyTree.View.commands.PersonCommands;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

public class ShowSpouse extends Command {

    public ShowSpouse (ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать супруга";
    }

    public void execute(){
        consoleUI.showSpouse();
    }
}
