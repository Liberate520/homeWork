package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddChildren extends Command {
    public AddChildren(ConsoleUI consoleUI) {
        super("Добавить ребенка", consoleUI);
    }

    public void execute() {
        getConsoleUI().addChildren();
    }
}
