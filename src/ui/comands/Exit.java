package ui.comands;

import ui.Console;

public class Exit extends Command{
    public Exit(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Закончить работу";
    }

    @Override
    public boolean execute() {
        getConsole().finish();
        return false;
    }
}
