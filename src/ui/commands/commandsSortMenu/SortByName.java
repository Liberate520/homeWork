package ui.commands.commandsSortMenu;

import ui.Console;
import ui.commands.Option;

public class SortByName extends Option{
    public SortByName(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Сортировка по имени.";
    }

    @Override
    public void execute() {
        getConsole().sortByName();
    }
}
