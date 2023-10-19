package homeWork3.Core.Infrastructure;

import homeWork3.UI.Command;
import homeWork3.UI.Console;

public class SortByAge extends Command {
    public SortByAge(Console console) {
        super(console);
    }

    @Override
    public String details() {
        return "Сортировка семейного дерева по возрасту. ";
    }

    @Override
    public void execute() {
        getConsole().sortFamilyByAge();

    }

}
