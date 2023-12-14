package FamilyTree_homework.view.commands;

import FamilyTree_homework.view.Console;

public class SortByName extends Command {
    public SortByName(Console console) {
        super("Отсортировать по имени",console);
    }

    @Override
    public void execute() {
        getConsole().sortByName();
    }
}
