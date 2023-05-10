package ui.commands;

import ui.View;

public class SortByName implements Command{
    private View view;

    public SortByName (View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.sortByName();

    }

    @Override
    public String description() {
     
        return "Sort by name";
    }
}
