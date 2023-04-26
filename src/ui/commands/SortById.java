package ui.commands;

import ui.Console;

public class SortById extends Command{
    public SortById(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Sort Targarien by ID.";
    }

    @Override
    public void execute() {
        getConsole().sortById();
    }
}
