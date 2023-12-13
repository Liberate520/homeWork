package FamilyTree_homework.view.commands;

import FamilyTree_homework.view.Console;

public class SortByAge extends Command {
    public SortByAge(Console console) {
        super("Отсортировать по возрасту",console);
    }

    @Override
    public void execute() {
        getConsole().sortByAge();
    }
}
