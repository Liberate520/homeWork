package view.Commands;

import view.Console;

public class Show extends Command{
    public Show(Console console) {
        super(console);
    }

    @Override
    public String act() {
        return "Show all notes";
    }

    public void execute() {
        getConsole().printAll();
    }
}
