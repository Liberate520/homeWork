package ui.Commands;

import ui.Console;

public class Finish extends Command {

    public Finish(Console console) {
        super(console);
        description = "Завершить работу";
    }

    @Override
    public void execute() {
        console.finish();
    }
}
