package UI.commands;

import UI.Console;

public class Exit extends Command {
    public Exit(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Выйти из программы";
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
