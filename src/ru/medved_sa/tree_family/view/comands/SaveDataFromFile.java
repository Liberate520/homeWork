package ru.medved_sa.tree_family.view.comands;

import ru.medved_sa.tree_family.view.View;

public class SaveDataFromFile extends Command{


    public SaveDataFromFile(View view) {
        super(view, "Сохранить дерево в файл");
    }

    @Override
    public void execute() {
        getView().saveDataFromFile();

    }
}
