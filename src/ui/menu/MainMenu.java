package ui.menu;

import ui.ConsoleView;
import ui.menu.commands.Exit;
import ui.menu.commands.InputNote;
import ui.menu.commands.ShowAllNotes;

public class MainMenu extends Menu {

    public MainMenu(ConsoleView view) {
        super(view);
        super.setWelcome("Введите номер команды:");
        super.addCommand(new ShowAllNotes(this));
        super.addCommand(new InputNote(this));
        super.addCommand(new Exit(this));
    }
}
