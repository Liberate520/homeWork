package ui.menu.commands;

import ui.ConsoleOne;
import ui.menu.Option;

public abstract class Command implements Option {
    private ConsoleOne console;

    public Command(ConsoleOne console) {
        this.console = console;
    }

    public ConsoleOne getConsole() {
        return console;
    }
}
