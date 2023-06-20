package ui.menu;

import ui.UI;
import ui.menu.command.*;

public class MainMenu extends Menu {
    public MainMenu(UI view) {
        super(view, true, "Главное меню\n",
                new ShowFamilyTrees(view),
                new ListFamilies(view),
                new AddFamily(view),
                new GotoFamily(view),
                new FileOperations(view)
        );
    }
}