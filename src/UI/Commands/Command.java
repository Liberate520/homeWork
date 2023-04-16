package UI.Commands;

import UI.Console;

public abstract class Command implements Option{
    private Console console;

    public Command(Console console) {
        this.console = console;
    }

    public abstract String getDescription();

    public Console getConsole() {
        return console;
    }

    public abstract void execute();

}
