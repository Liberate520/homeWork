package ui.menuitems;

import ui.View;

public class Exit extends MenuMethods{
    public Exit(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Выход";
    }

    @Override
    public void run() {
        getUI().exit();
    }
}
