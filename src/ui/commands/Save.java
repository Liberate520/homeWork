package ui.commands;

import ui.Console;

import java.io.IOException;

public class Save extends Command{
    public Save(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сохранить список";
    }

    @Override
    public void execute() throws IOException {
        getConsole().save();
    }
}