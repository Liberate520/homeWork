package view.menu;

import view.Console;

public class SortByBirthDate implements Command{
    public Console console;
    public SortByBirthDate(Console console) {
        this.console = console;
    }
    @Override
    public String getDescription() {
        return "Сортировать дерево по дате рождения";
    }
    @Override
    public void execute() {
        console.sortByBirthDate();
    }
}
