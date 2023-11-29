package ru.medved_sa.tree_family.view.comands;

import ru.medved_sa.tree_family.view.View;

public class ReadDataFromFile extends Command {

    public ReadDataFromFile(View view) {
        super(view, "Загрузить дерево из файла...");
    }

    @Override
    public void execute() {
        getView().readDataFromFile();

    }
}
