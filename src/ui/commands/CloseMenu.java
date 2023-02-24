package src.ui.commands;

import src.ui.Console;

public class CloseMenu extends Command {

    public CloseMenu(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Закончить работу";
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
