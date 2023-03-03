package HW01.ui.commands;

import HW01.ui.Console;

public class AddPerson extends Command {

    public AddPerson(Console console) {
        super(console);
    }

    @Override
    public String description() {
            return "Добавить запись о новом человеке";
    }

    @Override
    public void execute() {
        getConsole().addPerson();
    }

}
