package commands;

import UI.Console;

public class DeleteEntry extends Command {
    public DeleteEntry(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Удалить запись";
    }

    @Override
    public void execute() {
        super.getConsole().deleteEntry();
    }
}