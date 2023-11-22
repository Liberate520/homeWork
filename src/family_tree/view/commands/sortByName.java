package family_tree.view.commands;

import family_tree.view.View;

public class sortByName extends Commands {

    public sortByName(View view) {
        super("Сортировать по имени", view);
    }

    public void execute() {
        getView().sortByName();
    }
}