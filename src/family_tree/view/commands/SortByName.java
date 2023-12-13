package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByName extends Command{


    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}

