package family_tree.view.commands.sort;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUi) {
        super(consoleUi, "Сортировка по возрасту.");
    }

    @Override
    public void execute() {
        super.consoleUi.sortByAge();
    }
}
