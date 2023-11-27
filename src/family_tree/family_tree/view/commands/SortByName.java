package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.View;

public class SortByName extends Command {

    public SortByName(View view) {
        super("Отсортировать по имени", view);
    }

    public void execute(){
        getView().sortByName();
    }
}
