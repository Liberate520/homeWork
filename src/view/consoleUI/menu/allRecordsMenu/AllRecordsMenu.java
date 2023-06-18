package view.consoleUI.menu.allRecordsMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.Menu;
import view.consoleUI.menu.mainMenu.commands.GetRecord;
import view.consoleUI.menu.mainMenu.commands.ReturnBack;
import view.consoleUI.menu.allRecordsMenu.commands.ShowAllRecord;
import view.consoleUI.menu.allRecordsMenu.commands.SortedTree;

import java.util.Arrays;

public class AllRecordsMenu extends Menu {
    public AllRecordsMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new ShowAllRecord(consoleUI),
                new GetRecord(consoleUI),
                new SortedTree(consoleUI),
                new ReturnBack(consoleUI)));
    }


}
