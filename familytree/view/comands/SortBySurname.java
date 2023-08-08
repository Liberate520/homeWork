package familytree.view.comands;

import familytree.view.Console;

public class SortBySurname extends Comand{

    public SortBySurname(Console console) {
        super(console);
        description = "Сортировка по фамилии";
    }

    @Override
    public void execute() {
        console.sortBySurname();
    }
}