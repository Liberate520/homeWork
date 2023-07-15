package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class StopMarriage extends Command {
    public StopMarriage(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Расторгнуть брак";
    }

    public void execute(){
        consoleUI.stopMarriage();
    }
}
