package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.View;

public class DeleteRecord implements Command {
    private View view;

    public DeleteRecord(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Удалить обьект из семейного дерева";
    }

    @Override
    public void execute() {
        view.deleteRecord();
    }
}