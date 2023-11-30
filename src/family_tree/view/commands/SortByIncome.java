package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByIncome extends Command {
    public SortByIncome(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "отсортировать список по доходам";
    }

    @Override
    public void execute() {
        consoleUI.sortByIncome();
    }
}
