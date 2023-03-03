package src.UI.commands;

import src.UI.Console;
import src.UI.Option;


public abstract class Command implements Option {
    private Console console;

    public Command(Console console) {
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }
}
