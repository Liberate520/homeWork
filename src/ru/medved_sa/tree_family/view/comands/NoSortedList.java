package ru.medved_sa.tree_family.view.comands;

import ru.medved_sa.tree_family.view.View;

public class NoSortedList extends Command {

    public NoSortedList(View view) {
        super(view, "Неотсортированный список");
    }

    @Override
    public void execute() {
        getView().noSortedList();
    }
}
