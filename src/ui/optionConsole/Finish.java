package ui.optionConsole;

import ui.Console;

public class Finish extends Option {

    public Finish(Console console) {
        super(console);
        setDescription("Завершить работу.");
    }

    @Override
    public void execute() {
        super.getConsole().finish();
    }
}
