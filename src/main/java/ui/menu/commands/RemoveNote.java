package ui.menu.commands;

import ui.menu.Menu;

public class RemoveNote extends MenuCommand{

    public RemoveNote(Menu menu) {
        super(menu, "Удалить запись");
    }
    @Override
    public void run() {
        super.getView().removeNote();
    }
}
