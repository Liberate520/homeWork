package UI.commands;

import UI.Console;

public abstract class Command {
    private Console console;

    public Command(Console console) {
        this.console = console;
    }
    public abstract String getDescription();
    public abstract void execute();

    public Console getConsole() {
        return console;
    }
}
