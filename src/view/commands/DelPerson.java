package view.commands;

import view.Console;

public class DelPerson extends Command {
    public DelPerson(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Удалить человека";
    }

    @Override
    public void execute(){
        getConsole().delPerson();
    }
}