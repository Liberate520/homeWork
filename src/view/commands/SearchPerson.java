package view.commands;

import view.Console;

public class SearchPerson extends Command {
    public SearchPerson(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Поиск по фамилии";
    }

    @Override
    public void execute() {getConsole().searchPerson();
    }
}