package home1.ui.commands;

import home1.ui.Console;

public class HumanSearch extends Command {
    public HumanSearch(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Поиск человека по имени. ";
    }

    @Override
    public void execute() {
        getConsole().humanSearch();
    }
}
