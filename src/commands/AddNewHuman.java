package commands;

import UI.Console;

public class AddNewHuman extends Command {
    public AddNewHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
        super.getConsole().addNewHuman();
    }
}