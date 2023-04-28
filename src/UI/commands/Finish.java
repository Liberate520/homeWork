package UI.commands;

import UI.Console;

import java.io.IOException;

public class Finish implements Command {
    private Console console;

    public Finish(Console console) {
        this.console = console;
    }

    @Override
    public String description() {
        return "Завершить работу";
    }

    @Override
    public void run() {
        console.finish();
    }
}
