package ui.Commands;

import ui.View;

public class SortByBirthYear implements Command {
    public View view;

    public SortByBirthYear(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "сортировка дерева по году рождения:";
    }

    @Override
    public void execute() {
        view.sortByBirthYear();
    }
}

