package commands;

import ui.Console;

public class Exit implements Commands {

    Console console;

    public Exit(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {

        System.exit(0);
    }

    @Override
    public String description() {
        return "завершение программы";
    }
}
