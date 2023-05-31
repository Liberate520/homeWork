package oop.familyTree.mvp.view.console.commands;

import oop.familyTree.mvp.view.View;

public class ShowNameFamilyTree implements Commands{

    private final View view;

    public ShowNameFamilyTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать имена всех сохранённых древ";
    }

    @Override
    public void execute() {
        view.showNameFamilyTree();
    }
}
