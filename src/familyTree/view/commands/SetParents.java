package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class SetParents extends Command{
    public SetParents(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Add parents (Use only after adding family members)";
    }

    @Override
    public void execute() {
        consoleUI.setParents();
    }
}
