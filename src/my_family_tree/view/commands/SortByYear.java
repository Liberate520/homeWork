package my_family_tree.view.commands;

import my_family_tree.view.View;

public class SortByYear extends Command {

    public SortByYear(View view) {
        super("Сортировать по году рождения", view);
    }

    public void execute() {
        view.sortByYear();
    }
}
