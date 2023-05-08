package Package.View.Commands.ShowTreeSubMenuCommands;

import Package.View.Console;

public class SortByBirthdate implements SubMenuCommands{
    private Console console;

    public SortByBirthdate(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Сортировать по дате рождения";
    }

    @Override
    public void execute() {
        console.sortByBirthdate();
        console.showTree();
    }
}
