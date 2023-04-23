package view.commands;

import view.Console;

public class AddPerson extends Command {
    public AddPerson(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
        getConsole().addPerson();
    }
}