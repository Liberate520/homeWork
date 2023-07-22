package family_tree.view.commands;

import family_tree.view.Console;

public abstract class Command {
    String description;
    Console console;

    public Command(Console console) {
        this.console = console;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
