package ui.menu.commands;

import ui.ConsoleOne;

public class Exit extends Command {

    public Exit(ConsoleOne console) {
        super(console);
    }

    @Override
    public String description() {
        return "Exit";
    }

    @Override
    public void execute() {
        getConsole().exit();
    }

}
