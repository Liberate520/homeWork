package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class AddToFamily extends Command{
    public AddToFamily(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Add new family's member";
    }

    public void execute() {
        consoleUI.addToFamily();
    }
}
