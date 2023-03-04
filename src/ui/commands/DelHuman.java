package src.ui.commands;

import src.ui.Console;

import java.io.IOException;

public class DelHuman extends Command{
    public DelHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Удалить запись";
    }

    @Override
    public void execute() {
        getConsole().delHuman();
    }
}
