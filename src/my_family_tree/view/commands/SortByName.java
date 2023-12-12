package my_family_tree.view.commands;

import my_family_tree.view.View;

public class SortByName extends Command {

    public SortByName(View view) {
        super("Сортировать по имени", view);
    }

    public void execute() {
        view.sortByName();
    }
}
