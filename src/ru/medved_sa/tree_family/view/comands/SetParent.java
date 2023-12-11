package ru.medved_sa.tree_family.view.comands;

import ru.medved_sa.tree_family.view.View;

public class SetParent extends Command {


    public SetParent(View view) {
        super(view, "Установить родителя...");
    }

    @Override
    public void execute() {
        getView().setParent();
    }
}
