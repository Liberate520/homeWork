package ui.commands;

import ui.View;

public class SortByFirstName implements Command {
    private View view;

    public SortByFirstName(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Сортировать по имени";
    }

    @Override
    public void execute() {
        view.sortByFirstName();

    }
}
