package oop.familyTree.mvp.view.console.commands;

import oop.familyTree.mvp.view.View;

public class AddNewHuman implements Commands{

    private final View view;

    public AddNewHuman(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить нового человека";
    }

    @Override
    public void execute() {
        view.addNewHuman();
    }
}
