package ui.menu.commands;

import ui.menu.Menu;

public class SaveAllNotes extends MenuCommand{
    public SaveAllNotes(Menu menu) {
        super(menu, "Сохранить записи");
    }
    @Override
    public void run() {
        super.getView().saveAllNotes();
    }
}
