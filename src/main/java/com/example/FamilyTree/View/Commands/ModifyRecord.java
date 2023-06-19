package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.View;

public class ModifyRecord implements Command {
    private View view;

    public ModifyRecord(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Изменить обьект в семейном дереве";
    }

    @Override
    public void execute() {
        view.modifyRecord();
    }
}