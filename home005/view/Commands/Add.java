package view.Commands;

import view.Console;

public class Add extends Command{
    public Add(Console console) {
        super(console);
    }

    @Override
    public String act() {
        return "Add note";
    }

    @Override
    public void execute() {
        getConsole().addNote();
    }
}
