package src.ui.commands;

import src.ui.Console;

public class ShowHumans extends Command {
    public ShowHumans(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Вся семья, список";
    }

    @Override
    public void execute() {
        getConsole().showHumans();
    }
}
