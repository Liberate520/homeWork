package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.View;

public class ViewRecord implements Command {
    private View view;

    public ViewRecord(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Вывести семейное дерево для объекта";
    }

    @Override
    public void execute() {
        view.viewRecord();
    }
}