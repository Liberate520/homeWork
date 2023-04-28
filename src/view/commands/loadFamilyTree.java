package view.commands;

import view.View;

import java.io.IOException;

public class loadFamilyTree implements Command{
    private View view;

    public loadFamilyTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Загрузка древа из файла";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        view.loadFamilyTree();
    }
}
