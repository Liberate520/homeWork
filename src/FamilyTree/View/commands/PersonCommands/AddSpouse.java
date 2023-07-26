package FamilyTree.View.commands.PersonCommands;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

public class AddSpouse extends Command {
    public AddSpouse (ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить супруга";
    }

    public void execute(){
        consoleUI.addSpouse();
    }
}
