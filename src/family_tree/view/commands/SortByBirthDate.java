package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByBirthDate extends Command {
    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI, "Отсортировать по дате рождения");
    }

    public void execute() {
        consoleUI.sortByBirthDate();
    }
}

