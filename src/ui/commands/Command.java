package ui.commands;

import ui.Console;

import java.io.IOException;

public abstract class Command {

    final  Console console;
    String description;


    public Command(Console console) {
        this.console = console;
    }

    public String getDescription() {
        return description;
    }

    public void execute(){

    }
}
