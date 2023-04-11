package view.Commands;

import view.Console;

public abstract class Command {
    private final Console console;

    public Command(Console console) {
        this.console = console;
   }

    public abstract String act();

    public Console getConsole() {
        return console;
    }

    public abstract void execute();
}
