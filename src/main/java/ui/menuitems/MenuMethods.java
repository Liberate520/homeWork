package ui.menuitems;

import ui.ConsoleUI;
import ui.MenuItem;

public abstract class  MenuMethods implements MenuItem {
    private ConsoleUI consoleUI;

    public MenuMethods(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}
