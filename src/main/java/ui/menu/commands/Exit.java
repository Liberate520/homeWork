package ui.menu.commands;

import ui.menu.Menu;

public class Exit extends MenuCommand {

    public Exit(Menu menu) {
        super(menu, "Выход");
    }

    public void run() {
        super.getView().exit();
    }
}
