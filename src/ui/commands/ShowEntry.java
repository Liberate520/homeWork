package ui.commands;

import ui.Console;

public class showEntry extends Command {
    public showEntry(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Show human info";
    }

    @Override
    public void execute() {
        super.getConsole().showEntry();
    }
}
