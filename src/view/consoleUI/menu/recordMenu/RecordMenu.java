package view.consoleUI.menu.recordMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.Menu;
import view.consoleUI.menu.mainMenu.commands.ReturnBack;
import view.consoleUI.menu.recordMenu.commands.GetChildren;
import view.consoleUI.menu.recordMenu.commands.GetParents;

import java.util.Arrays;

public class RecordMenu extends Menu {

    public RecordMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new GetChildren(consoleUI),
                new GetParents(consoleUI),
                new ReturnBack(consoleUI)));
    }


}
