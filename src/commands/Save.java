package commands;

import UI.Console;

import java.io.IOException;

public class Save extends Command {
    public Save(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сохранить";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        super.getConsole().save();
    }
}