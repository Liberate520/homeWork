package FamilyTree.View.commands.PersonCommands;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

public class AddChildren extends Command {
    public AddChildren (ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка";
    }

    public void execute(){
        consoleUI.addChildren();
    }
}


