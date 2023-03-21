package ui.menuitems;

import ui.ConsoleUI;
import ui.MenuItem;
import ui.View;

public abstract class  MenuMethods implements MenuItem {
    private View view;

    public MenuMethods(View view) {
        this.view = view;
    }

    public View getUI() {
        return view;
    }
}
