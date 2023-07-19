package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Exit extends Command{

    public Exit(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Выход;";
    }
    public void execute() {
        consoleUI.exit();
    }
}
