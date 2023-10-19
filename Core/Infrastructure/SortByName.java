package homeWork3.Core.Infrastructure;

import homeWork3.UI.Command;
import homeWork3.UI.Console;

public class SortByName extends Command {
    public SortByName(Console console) {
        super(console);
    }

    @Override
    public String details() {
        return "Сортировка семейного дерева по имени. ";
    }

    @Override
    public void execute() {
        getConsole().sortFamilyByName();
    }
}
