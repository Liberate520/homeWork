package FamilyTree.view.commands;

import FamilyTree.view.View;

public class SortByName extends Command{

    public SortByName(View view) {
        super("Отсортировать по имени.", view);
    }

    public void execute(){ getView().sortByName(); }
}
