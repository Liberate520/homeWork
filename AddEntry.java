package commands;

import UI.Console;

public class AddEntry extends Command {
    public AddEntry(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
        super.getConsole().addEntry();
    }
}