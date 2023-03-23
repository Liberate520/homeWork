package ui.commands;

import ui.Console;

import javax.swing.text.View;

public abstract class Command implements Option {
    
    private Console console;

    public Command (Console console) {
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }
}
