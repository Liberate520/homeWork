package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByDateBirth extends Command {
    public SortByDateBirth(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по возрасту";
    }

    @Override
    public void execute() {
        consoleUI.sortByDateBirch();
    }
}
