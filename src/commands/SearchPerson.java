package commands;

import ui.Console;

public class SearchPerson extends Command{
    public SearchPerson(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Поиск человека по имени.";
    }

    @Override
    public void execute() {
        getConsole().searchPerson();
    }
}
