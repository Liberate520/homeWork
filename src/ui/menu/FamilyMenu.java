package ui.menu;

import model.family.Family;
import model.human.Human;
import ui.UI;
import ui.menu.command.*;

public class FamilyMenu extends Menu {
    public FamilyMenu(UI view, Family<Human> family) {
        super(view, true, String.format("Меню семьи '%s'\n", family.getName()),
                new ShowPeople(view, family),
                new AddHuman(view, family),
                new AddConnection(view, family)
        );
    }
}
