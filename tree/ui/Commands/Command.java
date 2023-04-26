package ui.Commands;

import ui.Console;

public abstract class Command {
    protected String description;
    protected final Console console;

    public Command(Console console) {
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();

}
