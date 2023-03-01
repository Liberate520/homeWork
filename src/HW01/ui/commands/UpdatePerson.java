package HW01.ui.commands;

import HW01.ui.Console;

public class UpdatePerson extends Command {

    public UpdatePerson(Console console) {
        super(console);
    }

    @Override
        public String description() {
            return "Изменить информацию о человеке";
    }

    @Override
    public void execute() {
        getConsole().updatePerson();
    }

}
