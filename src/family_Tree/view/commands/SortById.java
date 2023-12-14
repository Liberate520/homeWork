package family_Tree.view.commands;

import family_Tree.view.ConsoleUI;

public class SortById extends Command{
    public SortById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выполнить сортировку по ID";
    }

    @Override
    public void execute() {
        consoleUI.sortById();
    }
}
