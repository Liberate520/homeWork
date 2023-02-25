package src.ui.commands;

import src.ui.Console;

import java.io.IOException;

public class FindHumans extends Command {
    public FindHumans(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Поиск людей";
    }

    @Override
    public void execute() {
        getConsole().findHumans();
    }
}
