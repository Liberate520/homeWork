package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByGender extends Command{
    public SortByGender(ConsoleUI console) {
        super("Сортировка полу", console);
    }

    public void execute() {
        getConsole().sortByGender();
    }
}
