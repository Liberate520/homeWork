package ui.menu;

import ui.UI;
import ui.menu.command.*;

public class FamilyMenu extends Menu {
    public FamilyMenu(UI view, String familyID) {
        super(view, true, String.format("Меню семьи '%s'\n", familyID),
                new ShowPeople(view, familyID),
                new AddHuman(view, familyID),
                new AddConnection(view, familyID)
        );
    }
}
