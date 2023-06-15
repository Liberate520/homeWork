package view.menu.sortMenu;

import view.ConsoleUI;
import view.menu.BaseMenu;
import view.menu.sortMenu.commands.SortByAlphabeticalOrder;
import view.menu.sortMenu.commands.SortByDateBirth;
import view.menu.sortMenu.commands.SortByNameLength;

import java.util.Arrays;
public class SortingMenu extends BaseMenu {
    public SortingMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new SortByAlphabeticalOrder(consoleUI),
                new SortByDateBirth(consoleUI),
                new SortByNameLength(consoleUI)));
    }
}
