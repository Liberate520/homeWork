package ui.commands;

import ui.Menu;

public class ShowAllNotes extends MenuCommand {

    public ShowAllNotes(Menu menu) {

        super(menu, "Показать все записи");
    }

    @Override
    public void run() {
        super.getView().showAllNotes();
    }
}
