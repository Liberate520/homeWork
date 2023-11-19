package family_Tree.view.commands;

import family_Tree.view.ConsoleUI;

public class AddParent extends Command{
    public AddParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить родителя";
    }

    @Override
    public void execute() {
        consoleUI.addParent();
    }
}
