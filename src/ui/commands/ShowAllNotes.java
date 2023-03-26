package ui.commands;

import ui.ConsoleView;

public class ShowAllNotes extends MenuCommand {

    public ShowAllNotes(ConsoleView view) {

        super(view, "Показать все записи");
    }

    @Override
    public void run() {
        view.showAllNotes();
    }
}
