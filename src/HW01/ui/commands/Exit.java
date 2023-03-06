package HW01.ui.commands;

import HW01.ui.Console;

public class Exit extends Command {

    public Exit(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Завершение работы";
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
