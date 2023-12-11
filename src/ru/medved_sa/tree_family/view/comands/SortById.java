package ru.medved_sa.tree_family.view.comands;

import ru.medved_sa.tree_family.view.View;

public class SortById extends Command {

    public SortById(View view) {
        super(view, "Отсортировать список по ID...");
    }

    @Override
    public void execute() {
        getView().sortById();
    }
}
