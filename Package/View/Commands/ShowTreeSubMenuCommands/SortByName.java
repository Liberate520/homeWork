package Package.View.Commands.ShowTreeSubMenuCommands;

import Package.View.Console;

public class SortByName implements SubMenuCommands{
    private Console console;

    public SortByName(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Сортировать по имени";
    }

    @Override
    public void execute() {
        console.sortByName();
        console.showTree();
    }
}
