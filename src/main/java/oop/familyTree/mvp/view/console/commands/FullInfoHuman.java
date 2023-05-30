package oop.familyTree.mvp.view.console.commands;

import oop.familyTree.mvp.view.View;

public class FullInfoHuman implements Commands {

    private final View view;

    public FullInfoHuman(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Получение информации о человеке";
    }

    @Override
    public void execute() {
        view.fullInfoHuman();
    }
}
