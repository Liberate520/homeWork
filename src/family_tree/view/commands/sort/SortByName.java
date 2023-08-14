package family_tree.view.commands.sort;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUi) {
        super(consoleUi, "Сортировка по имени.");
    }

    @Override
    public void execute() {
        super.consoleUi.sortByName();
    }
}
