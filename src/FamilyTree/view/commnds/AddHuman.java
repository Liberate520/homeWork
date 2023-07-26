package FamilyTree.view.commnds;

import FamilyTree.view.UI;

public class AddHuman extends Commnd{

    public AddHuman(UI ui){
        super(ui);
        description = "Добавить человека";
    }

    public void execute(){
        ui.add();
    }
}
