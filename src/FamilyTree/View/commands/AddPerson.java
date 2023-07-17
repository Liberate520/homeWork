package FamilyTree.View.commands;

import FamilyTree.View.ConsoleUI;

public class AddPerson extends Command{

    public AddPerson(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить родственника";
    }

    public void execute(){
        consoleUI.addPerson();
    }
}
