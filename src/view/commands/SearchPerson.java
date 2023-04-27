package view.commands;

import view.Console;

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
