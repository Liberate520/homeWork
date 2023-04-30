package ui.Commands;

import ui.View;

public class sortByBirthYear implements Command {
    public View view;
    public sortByBirthYear(View view){
        this.view=view;
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

