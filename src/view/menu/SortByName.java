package view.menu;

import view.Console;

public class SortByName implements Command{
    public Console console;

    public SortByName(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Сортировать дерево по имени";
    }

    @Override
    public void execute() {
        console.sortByName();
    }
}
