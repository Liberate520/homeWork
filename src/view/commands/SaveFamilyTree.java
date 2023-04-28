package view.commands;

import view.View;

import java.io.IOException;

public class SaveFamilyTree implements Command{
    private View view;

    public SaveFamilyTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сохранение древа в файл";
    }

    @Override
    public void execute() throws IOException {
        view.saveFamilyTree();
    }
}
