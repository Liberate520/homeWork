package ui.commands.commandsSortMenu;

import ui.Console;
import ui.commands.Option;

public class SortByYearOfBirth extends Option{
    public SortByYearOfBirth(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Сортировка по году рождения.";
    }

    @Override
    public void execute() {
        getConsole().sortByYearOfBirth();
    }
}