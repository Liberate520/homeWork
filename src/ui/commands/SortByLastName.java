package ui.commands;

import ui.View;

public class SortByLastName implements Command{
    private View view;

    public SortByLastName(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Сортировать по фамилии";
    }

    @Override
    public void execute() {
        view.sortByLastName();
    }
}
