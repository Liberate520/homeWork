package oop.familyTree.mvp.view.console.commands;

import oop.familyTree.mvp.view.View;

public class SetChangeField implements Commands {

    private final View view;

    public SetChangeField(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Изменение значения поля";
    }

    @Override
    public void execute() {
        view.changeField();
    }
}
