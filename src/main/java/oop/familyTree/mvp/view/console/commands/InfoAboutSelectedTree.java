package oop.familyTree.mvp.view.console.commands;

import oop.familyTree.mvp.view.View;

public class InfoAboutSelectedTree implements Commands{
    private final View view;

    public InfoAboutSelectedTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Получить информацию по выбранному древу";
    }

    @Override
    public void execute() {
        view.infoAboutSelectedTree();
    }
}
