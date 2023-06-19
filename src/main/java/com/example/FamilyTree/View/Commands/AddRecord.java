package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.View;

public class AddRecord implements Command {
    private View view;

    public AddRecord(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить обьект в семейное дерево";
    }

    @Override
    public void execute() {
        view.addRecord();
    }
}