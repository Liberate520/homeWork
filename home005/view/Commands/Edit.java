package view.Commands;

import view.Console;

public class Edit extends Command{
    public Edit(Console console) {
        super(console);
    }

    @Override
    public String act() {
        return "Edit note";
    }

    @Override
    public void execute() {
        getConsole().editNote();
    }
}
