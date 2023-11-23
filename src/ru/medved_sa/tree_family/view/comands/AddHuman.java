package ru.medved_sa.tree_family.view.comands;

import ru.medved_sa.tree_family.view.View;

public class AddHuman extends Command {

    public AddHuman(View view) {
        super(view, "Добавить человека:");
    }

    @Override
    public void execute() {
        getView().addHuman();
    }
}
