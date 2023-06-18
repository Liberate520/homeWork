package view.consoleUI.menu.endMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.Menu;
import view.consoleUI.menu.endMenu.commands.Finish;
import view.consoleUI.menu.mainMenu.commands.ReturnBack;
import view.consoleUI.menu.endMenu.commands.Save;

import java.util.Arrays;

public class EndMenu extends Menu {
    public EndMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new ReturnBack(consoleUI),
                new Save(consoleUI),
                new Finish(consoleUI)));
    }
}
