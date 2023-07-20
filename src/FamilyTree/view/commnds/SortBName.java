package FamilyTree.view.commnds;

import FamilyTree.view.UI;

public class SortBName extends Commnd{
    public SortBName(UI ui){
        super(ui);
        description = "Отсортировать по имени";
    }

    public void execute(){
        ui.sortByName();
    }
}
