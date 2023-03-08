package src.UI.commands;

import src.UI.Console;

public class Save extends Command {
    public Save(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Save to file";
    }
    @Override
    public void execute() {
        getConsole().save();
    }
}
