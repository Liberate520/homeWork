package FamilyTree.View.commands.PersonCommands;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

public class AddParents extends Command {
    public AddParents(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить родителя";
    }

    public void execute(){
        consoleUI.addParents();
    }
}