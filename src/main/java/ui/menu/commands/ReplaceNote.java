package ui.menu.commands;

import ui.menu.Menu;

public class ReplaceNote extends MenuCommand{
    public ReplaceNote(Menu menu) {
        super(menu, "Изменить запись");
    }
    @Override
    public void run() {
        super.getView().replaceNote();
    }
}
