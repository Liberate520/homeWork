package oop.familyTree.mvp.view.console.commands;

import oop.familyTree.mvp.view.View;

public class AddNewTree implements Commands {
    private final View view;

    public AddNewTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить новое древо";
    }

    @Override
    public void execute() {
        view.addNewTree();
    }
}
