package family_tree.view.commands;

import family_tree.view.View;

public class SortByAge extends Command {
    private String title;
    private View view;

    public SortByAge(View view) {
        super("Сортировка семейного дерева по возрасту",view);
    }

    public void execute(){
        getView().sortByAge();
    }
}
