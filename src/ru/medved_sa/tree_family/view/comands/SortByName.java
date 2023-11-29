package ru.medved_sa.tree_family.view.comands;

import ru.medved_sa.tree_family.view.View;

public class SortByName extends Command {

    public SortByName(View view) {
        super(view, "Отсортировать список по имени...");
    }

    public void execute() {
        getView().sortByName();
    }
}
