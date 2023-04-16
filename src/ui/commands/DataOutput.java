package ui.commands;

import ui.Console;

public class DataOutput extends Command{

    public DataOutput(Console console) {
        super(console);
    }
    @Override
    public String getDescription() {
        return "Data base initialisation.";
    }

    @Override
    public void execute() {
        getConsole().dataOutput();
    }
}
