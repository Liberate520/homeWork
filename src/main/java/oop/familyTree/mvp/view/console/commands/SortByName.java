package oop.familyTree.mvp.view.console.commands;

import oop.familyTree.mvp.view.View;

public class SortByName implements Commands{
    private final View view;

    public SortByName(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сортировка древа по имени";
    }

    @Override
    public void execute() {
        view.sortByName();
    }
}
