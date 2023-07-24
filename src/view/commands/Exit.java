package view.commands;

import view.Console;

public class Exit extends Command {
    public Exit(Console console) {
        super(console);
        description = "Выход";

    }

    public void execute() {
        console.exit();
    }
}
