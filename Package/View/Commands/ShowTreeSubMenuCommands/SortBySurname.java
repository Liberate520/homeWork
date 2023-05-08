package Package.View.Commands.ShowTreeSubMenuCommands;

import Package.View.Console;

public class SortBySurname implements SubMenuCommands{
    private Console console;

    public SortBySurname(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Сортировать по фамилии";
    }

    @Override
    public void execute() {
        console.sortBySurname();
        console.showTree();
    }
}
