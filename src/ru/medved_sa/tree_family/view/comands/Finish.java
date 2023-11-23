package ru.medved_sa.tree_family.view.comands;

import ru.medved_sa.tree_family.view.View;

public class Finish extends Command {

    public Finish(View view) {
        super(view, "До новых встреч...");
    }

    @Override
    public void execute() {
        getView().finish();
    }
}
