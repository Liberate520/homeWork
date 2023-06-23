package ui.commands;

import ui.Console;

public class Finish extends Command {

    public Finish(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Завершить работу";
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
