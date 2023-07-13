package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByYear extends Command {

    public SortByYear(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по году рождения";
    }

    @Override
    public void execute() {
        consoleUI.sortByYear();
    }

}
