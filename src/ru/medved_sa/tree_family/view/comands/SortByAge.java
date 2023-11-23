package ru.medved_sa.tree_family.view.comands;

import ru.medved_sa.tree_family.view.View;

public class SortByAge extends Command {

    public SortByAge(View view) {
        super(view, "Отсортировать список по возрасту:");
    }

    public void execute() {
        getView().sortByAge();
    }
}
