package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.View;

public class ShowRelatives implements Command{
    private View view;

    public ShowRelatives(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать родственную связь между двумя объектами";
    }

    @Override
    public void execute() {
        view.showRelatives();
    }
}
