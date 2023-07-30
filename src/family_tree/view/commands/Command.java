package family_tree.view.commands;

import family_tree.view.ConsoleUi;

public abstract class Command {
    ConsoleUi consoleUi;
    private String description;

    public Command(ConsoleUi consoleUi, String description) {
        this.consoleUi = consoleUi;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public abstract void execute();

}
