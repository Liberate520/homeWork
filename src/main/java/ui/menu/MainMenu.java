package ui.menu;

import ui.ConsoleView;
import ui.menu.commands.*;

public class MainMenu extends Menu {

    public MainMenu(ConsoleView view) {
        super(view);
        super.setWelcome("Введите номер команды:");
        super.addCommand(new ShowAllNotes(this));
        super.addCommand(new InputNote(this));
        super.addCommand(new RemoveNote(this));
        super.addCommand(new ReplaceNote(this));
        super.addCommand(new SaveAllNotes(this));
        super.addCommand(new Exit(this));
    }
}
