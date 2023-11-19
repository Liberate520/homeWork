package family_Tree.view.commands;

import family_Tree.view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выполнить сортировку по возрасту";
    }

    @Override
    public void execute() {
        consoleUI.sortByAge();
    }
}
