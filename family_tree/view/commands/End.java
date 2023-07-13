package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class End extends Command {

    public End(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    @Override
    public void execute() {
        consoleUI.end();
    }

}
