package ui.commands;

import human.Gender;
import ui.Console;

public class SaveFile implements Command{
    private Console console;

    public SaveFile(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Сохранить";
    }

    @Override
    public void execute() {
        console.save();
    }
}
