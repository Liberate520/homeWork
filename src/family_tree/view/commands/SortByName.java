package family_tree.view.commands;

import family_tree.view.View;

public class SortByName extends Command {
    private String title;
    private View view;

    public SortByName(View view) {
        super("Сортировка семейного дерева по имени",view);
    }

    public void execute(){
        getView().sortByName();
    }
}
