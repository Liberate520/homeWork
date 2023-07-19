package ui.commands;

import service.Service;
import ui.Console;
import ui.commands.Option;

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