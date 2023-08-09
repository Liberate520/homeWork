package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI console) {
        super("Сортировка возрасту", console);
    }

    public void execute() {
        getConsole().sortByAge();
    }
}
