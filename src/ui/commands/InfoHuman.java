package src.ui.commands;

import src.ui.Console;

import java.io.IOException;

public class InfoHuman  extends Command {
    public InfoHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Информация по человеку";
    }

    @Override
    public void execute() throws IOException {
        getConsole().infoHuman();
    }
}
