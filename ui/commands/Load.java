package ui.commands;

import ui.Console;

public class Load extends Command {
    public Load(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Load from file";
    }

    @Override
    public void execute() {
        super.getConsole().load();
    }
}