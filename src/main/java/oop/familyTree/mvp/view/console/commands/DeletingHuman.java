package oop.familyTree.mvp.view.console.commands;

import oop.familyTree.mvp.view.View;

public class DeletingHuman implements Commands{
    private final View view;

    public DeletingHuman(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Удаление человека из древа";
    }

    @Override
    public void execute() {
        view.deletingHuman();
    }
}
