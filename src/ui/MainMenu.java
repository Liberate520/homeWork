package ui;

import ui.commands.Exit;
import ui.commands.InputNote;
import ui.commands.ShowAllNotes;

public class MainMenu extends Menu {

    public MainMenu(ConsoleView view) {
        super(view);
        super.setWelcome("Введите номер команды:");
        super.addCommand(new ShowAllNotes(this));
        super.addCommand(new InputNote(this));
        super.addCommand(new Exit(this));
    }
}
