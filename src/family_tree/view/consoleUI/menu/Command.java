package family_tree.view.consoleUI.menu;

import family_tree.view.consoleUI.ConsoleUi;

public abstract class Command {
    private String description;
    private ConsoleUi consoleUi;

    public Command(String description, ConsoleUi consoleUi) {
        this.description = description;
        this.consoleUi = consoleUi;
    }

    public String getDescription() {
        return description;
    }

    public ConsoleUi getConsoleUi() {
        return consoleUi;
    }

    public abstract void execute();
}
