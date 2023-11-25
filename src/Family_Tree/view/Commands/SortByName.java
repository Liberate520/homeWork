package Family_Tree.view.Commands;

import Family_Tree.view.View;

public class SortByName extends Command{

    public SortByName(View view) {
        super("Отсортировать по имени", view);
    }

    public void execute(){
        getView().sortByName();
    }
}
