package my_family_tree.view.commands;

import my_family_tree.view.View;

public class SortByAge extends Command {

    public SortByAge(View view) {
        super("Сортировать по возрасту", view);
    }

    public void execute() {
        view.sortByAge();
    }
}