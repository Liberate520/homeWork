package ui.Commands;

import ui.View;

public class SortBySex implements Command {
    public View view;

    public SortBySex(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "сортировка дерева по полу:";
    }

    @Override
    public void execute() {
        view.sortBySex();
    }
}

