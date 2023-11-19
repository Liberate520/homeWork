package family_Tree.view.commands;

import family_Tree.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выполнить сортировку по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
}
