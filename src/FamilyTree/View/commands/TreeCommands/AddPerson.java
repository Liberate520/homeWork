package FamilyTree.View.commands.TreeCommands;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

public class AddPerson extends Command {

    public AddPerson(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека в дерево";
    }

    public void execute(){
        consoleUI.addPerson();
    }
}
