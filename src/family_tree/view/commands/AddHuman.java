package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить человека",consoleUI);
    }
    public void execute(){
        getConsoleUI().addHuman();
    }
}
