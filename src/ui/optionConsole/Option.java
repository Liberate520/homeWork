package ui.optionConsole;

import ui.Console;

public abstract class Option {
    private final Console console;
    private String description;

    public Option(Console console) {
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void execute();
}
