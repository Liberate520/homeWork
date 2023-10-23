package homeWork3.core.infrastructure;

import homeWork3.ui.Command;
import homeWork3.ui.Console;

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
