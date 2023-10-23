package homeWork3.core.infrastructure;

import homeWork3.ui.Command;
import homeWork3.ui.Console;

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
