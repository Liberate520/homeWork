package homeWork3.comparator;

import homeWork3.model.FamilyTree;
import homeWork3.model.Human;
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
