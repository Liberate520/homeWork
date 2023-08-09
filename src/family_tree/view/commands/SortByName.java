package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI console) {
        super("Сортировка имени", console);
    }

    public void execute() {
        getConsole().sortByName();
    }
}
