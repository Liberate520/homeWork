package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddParents extends Command {
    public AddParents(ConsoleUI consoleUI) {
        super("Добавить родителей",consoleUI);
    }
    public void execute(){
        // TODO поменять метод
        getConsoleUI().addParents();
    }
}
