package FamilyTree.view.commnds;

import FamilyTree.view.UI;

public class SortBAge extends Commnd{
    public SortBAge(UI ui){
        super(ui);
        description = "Отсортировать по возрасту";
    }

    public void execute(){
        ui.sortByAge();
    }
}
