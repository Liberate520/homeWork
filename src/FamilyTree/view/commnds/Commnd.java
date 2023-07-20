package FamilyTree.view.commnds;

import FamilyTree.view.UI;

public abstract class Commnd {
    String description;
    UI ui;

    public Commnd(UI ui){
        this.ui = ui;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
