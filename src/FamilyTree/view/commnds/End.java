package FamilyTree.view.commnds;

import FamilyTree.view.UI;

public class End extends Commnd{
    public End(UI ui){
        super(ui);
        description = "Выход";
    }

    public void execute(){
        ui.end();
    }
}
