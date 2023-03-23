package ui.comands;

import ui.ConsoleUI;

public class Exit extends Command{

    public Exit(ConsoleUI console) {
        super(console);
    }

    @Override
    public String description() {
        return "Завершить работу";
    }

    public void execute() {
        getConsole().finish();
    }
}
