package view.commands;

import view.Console;

public abstract class Command {

    protected String description;
    Console console;

    public Command(Console console) {
        this.console = console;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();

}
