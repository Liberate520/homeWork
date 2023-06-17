package view.consoleUI.menu.recordsMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.Menu;
import view.consoleUI.menu.mainMenu.commands.GetRecord;
import view.consoleUI.menu.mainMenu.commands.ReturnBack;
import view.consoleUI.menu.recordsMenu.commands.ShowAllRecord;
import view.consoleUI.menu.recordsMenu.commands.SortedTree;

import java.util.Arrays;

public class RecordsMenu extends Menu {
    public RecordsMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new ShowAllRecord(consoleUI),
                new GetRecord(consoleUI),
                new SortedTree(consoleUI),
                new ReturnBack(consoleUI)));
    }


}
