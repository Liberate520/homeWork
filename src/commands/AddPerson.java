package commands;

import ui.Console;

public class AddPerson extends Command {

    public AddPerson(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавление человека в семью.";
    }

    @Override
    public void execute() {
        getConsole().addPerson();
    }
}
