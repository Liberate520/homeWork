package ui.commands;

import ui.Console;

public class Deserialization extends Command{
    public Deserialization(Console console) {
            super(console);
        }

    @Override
    public String getDescription() {
        return "Data base deserialization.";
    }

    @Override
    public void execute() {
        getConsole().deserialization();
    }
}
