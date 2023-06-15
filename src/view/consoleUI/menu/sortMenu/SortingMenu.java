package view.consoleUI.menu.sortMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.Menu;
import view.consoleUI.menu.sortMenu.commands.SortByAlphabeticalOrder;
import view.consoleUI.menu.sortMenu.commands.SortByDateBirth;
import view.consoleUI.menu.sortMenu.commands.SortByNameLength;

import java.util.Arrays;
public class SortingMenu extends Menu {
    public SortingMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new SortByAlphabeticalOrder(consoleUI),
                new SortByDateBirth(consoleUI),
                new SortByNameLength(consoleUI)));
    }
}
