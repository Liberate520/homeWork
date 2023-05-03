package Package.View.Commands;

import Package.View.Console;

public class AddPerson implements Commander{
    private String description;
    private Console console;

    public AddPerson(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Добавить нового человека";
    }

    @Override
    public void execute() {
        console.addPerson();
    }
}
