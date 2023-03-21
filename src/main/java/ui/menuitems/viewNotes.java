package ui.menuitems;

import ui.ConsoleUI;
import ui.MenuItem;

public class viewNotes extends MenuMethods {


    public viewNotes(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String description() {
        return "Просмотр записей";
    }
    @Override
    public void run() {
        getConsoleUI().viewNotes();
    }
}
