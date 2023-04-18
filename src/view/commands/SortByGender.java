package view.commands;

import view.Console;

public class SortByGender extends Command {
    public SortByGender(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Сортировка по полу ";
    }

    @Override
    public void execute() {
        getConsole().sortByGender();
    }
}
