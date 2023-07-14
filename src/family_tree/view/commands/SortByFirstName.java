package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByFirstName extends Command {
    public SortByFirstName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByFirstName();
    }
}
