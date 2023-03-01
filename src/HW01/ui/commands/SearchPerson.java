package HW01.ui.commands;

import HW01.ui.Console;

public class SearchPerson extends Command {

    public SearchPerson(Console console) {
        super(console);
    }

    @Override
        public String description() {
            return "Поиск информации о человеке";
    }

    @Override
    public void execute() {
        getConsole().searchPerson();
    }

}
