package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByLastName extends Command {
    public SortByLastName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по фамилии";
    }

    @Override
    public void execute() {
        consoleUI.sortByLastName();
    }
}
