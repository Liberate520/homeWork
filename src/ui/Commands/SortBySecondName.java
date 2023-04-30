package ui.Commands;

import ui.View;

public class SortBySecondName implements Command {
    public View view;
    public SortBySecondName(View view){
        this.view=view;
    }

    @Override
    public String getDescription() {
        return "сортировка дерева по фамилиям:";
    }

    @Override
    public void execute() {
        view.SortBySecondName();
    }
}

