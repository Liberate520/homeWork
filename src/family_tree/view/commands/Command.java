package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public abstract class Command {

    String description;
    ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public abstract void execute();

    public String getDescription() {
        return description;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }


}
