package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Wedding extends Command {
    public Wedding(ConsoleUI consoleUI) {
        super("Свадьба",consoleUI);
    }
    public void execute(){
        getConsoleUI().wedding();
    }
}
