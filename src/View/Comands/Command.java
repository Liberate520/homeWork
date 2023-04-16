package View.Comands;

import Model.Service;
import View.Console;

public abstract class Command implements Option {
    private Console console;
    private Service service;

    public Command(Console console) {
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }
}
