package HW01.ui.commands;

import HW01.ui.Console;

public abstract class Command implements Option {
    private Console console;

    public Command(Console console) {
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }
}