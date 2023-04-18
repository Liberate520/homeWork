package UI.commands;

import UI.Console;
import UI.commands.interfaces.Option;

abstract class Command implements Option {
    private Console console;

    public Command(Console console) {
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }
}
