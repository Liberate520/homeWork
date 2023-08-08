package familytree.view.comands;

import familytree.view.Console;

public class SortByBirthdate extends Comand {

    public SortByBirthdate(Console console) {
        super(console);
        description = "Сортировка по дате рождения";
    }

    @Override
    public void execute() {
        console.sortByBirthDate();
    }
}