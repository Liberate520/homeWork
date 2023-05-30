package oop.familyTree.mvp.view.console.commands;

import oop.familyTree.mvp.view.View;

public class SortByAge implements Commands{
    private final View view;

    public SortByAge(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сортировка древа по возрасту";
    }

    @Override
    public void execute() {
        view.sortByAge();
    }
}
