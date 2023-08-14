package family_tree.view.commands.sort;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class SortBySurname extends Command{
    public SortBySurname(ConsoleUI consoleUi) {
        super(consoleUi, "Сортировка по фамилии.");
    }

    @Override
    public void execute() {
        super.consoleUi.sortBySurname();
    }
}
