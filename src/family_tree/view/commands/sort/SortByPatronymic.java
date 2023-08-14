package family_tree.view.commands.sort;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class SortByPatronymic extends Command{
    public SortByPatronymic(ConsoleUI consoleUi) {
        super(consoleUi, "Сортировка по отчеству.");
    }

    @Override
    public void execute() {
        super.consoleUi.sortByPatronymic();
    }
}
