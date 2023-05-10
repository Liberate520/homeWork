package ui.commands;

import ui.View;

public class SortBirthDate implements Command{
    private View view;

    public SortBirthDate (View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.sortBirthDate();

    }

    @Override
    public String description() {
       
        return "Sort birtg date";
    }
}
