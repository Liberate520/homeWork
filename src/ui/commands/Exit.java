package ui.commands;

import ui.Menu;

public class Exit extends MenuCommand {

    public Exit(Menu menu) {
        super(menu, "Выход");
    }

    public void run() {
        super.getView().exit();
    }
}
