package home1.ui.commands;

import home1.ui.Console;

public class Exit extends Command {
    public Exit(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Выход их программы.";
    }

    @Override
    public void execute() {
        getConsole().end();
    }
}
