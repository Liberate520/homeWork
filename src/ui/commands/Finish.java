package ui.commands;

import ui.Console;

public class Finish extends Command{

    public Finish(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Exit program.";
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
