package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SetDateOfDeath extends Command{

    public SetDateOfDeath(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выставить дату смерти";
    }

    @Override
    public void execute() {
        consoleUI.setDateOfDeath();
    }
}
