package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public abstract class Command {
    String description;
    ConsoleUI console;

    public Command(ConsoleUI console) {
        this.console = console;
    }
    public String getDescription() {
        return description;
    }
    public abstract void execute();
}
