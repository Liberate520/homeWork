package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
}
