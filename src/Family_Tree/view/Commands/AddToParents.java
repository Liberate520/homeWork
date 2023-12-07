package Family_Tree.view.Commands;

import Family_Tree.view.ConsoleUI;

public class AddToParents extends Command {

    public AddToParents(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить родителя";
    }

    @Override
    public void execute() {
        consoleUI.addToParents();
    }
}
