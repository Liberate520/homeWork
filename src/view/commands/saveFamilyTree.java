package view.commands;

import view.View;

import java.io.IOException;

public class saveFamilyTree implements Command{
    private View view;

    public saveFamilyTree(View view) {
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
