package commands;

import UI.Console;

public class Save extends Command {
    public Save(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сохранить";
    }

    @Override
    public void execute() {
        super.getConsole().save();
    }
}