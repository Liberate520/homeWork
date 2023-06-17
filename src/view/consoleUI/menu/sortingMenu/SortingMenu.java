package view.consoleUI.menu.sortingMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.Menu;
import view.consoleUI.menu.mainMenu.commands.GetRecord;
import view.consoleUI.menu.mainMenu.commands.ReturnBack;
import view.consoleUI.menu.recordsMenu.commands.ShowAllRecord;
import view.consoleUI.menu.sortingMenu.commands.SortByAlphabeticalOrder;
import view.consoleUI.menu.sortingMenu.commands.SortByDateBirth;
import view.consoleUI.menu.sortingMenu.commands.SortByNameLength;

import java.util.Arrays;
public class SortingMenu extends Menu {
    public SortingMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new ShowAllRecord(consoleUI),
                new GetRecord(consoleUI),
                new SortByAlphabeticalOrder(consoleUI),
                new SortByDateBirth(consoleUI),
                new SortByNameLength(consoleUI),
                new ReturnBack(consoleUI)));
    }
}
