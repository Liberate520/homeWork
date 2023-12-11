package ru.medved_sa.tree_family.view.comands;

import ru.medved_sa.tree_family.view.View;

public class GetHumanList extends Command {

    public GetHumanList(View view) {
        super(view, "Получить список людей...");
    }

    @Override
    public void execute() {
        getView().getHumanList();
    }
}
