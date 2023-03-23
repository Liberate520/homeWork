package commands;

import UI.Console;

import java.io.IOException;

public class Load extends Command {
    public Load(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Загрузить";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        super.getConsole().load();
    }
}