package ui.commands;

import ui.Console;

public class DelRecord extends Command {
    public DelRecord(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Удалить запись";
    }

    @Override
    public void execute() {

    }
}
