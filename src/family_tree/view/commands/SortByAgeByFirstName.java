package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByAgeByFirstName extends Command{
    public SortByAgeByFirstName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по возрасту и по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByAgeByFirstName();
    }
}
