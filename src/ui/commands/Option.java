package ui.commands;

import ui.Console;

public abstract class Option implements Command{
    private Console console;

    public Option(Console console) {
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }
}
