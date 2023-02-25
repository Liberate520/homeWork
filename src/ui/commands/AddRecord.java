package ui.commands;

import ui.Console;

public class AddRecord extends Command {
    public AddRecord(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить новую запись";
    }

    @Override
    public void execute() {
        getConsole().addRecord();
    }
}
