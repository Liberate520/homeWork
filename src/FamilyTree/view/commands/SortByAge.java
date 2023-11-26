package FamilyTree.view.commands;

import FamilyTree.view.View;

public class SortByAge extends Command{

    public SortByAge(View view) {
        super("Отсортировать по возрасту.", view);
    }

    public void execute(){ getView().sortByAge(); }
}
