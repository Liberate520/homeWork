package FamilyTree.view.commnds;

import FamilyTree.view.UI;

public class GetHumanInfo extends Commnd{
    public GetHumanInfo(UI ui){
        super(ui);
        description = "Вывести список древа";
    }

    public void execute(){
        ui.getlistinfo();
    }
}
