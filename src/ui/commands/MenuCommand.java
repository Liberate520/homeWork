package ui.commands;

import ui.ConsoleView;
import ui.Menu;

public abstract class MenuCommand {
    // private ConsoleView view;
    private String description;
    private Menu menu;

    MenuCommand(Menu menu, String description) {
        this.menu = menu;
        this.description = description;
    }

    public void run() {
    };

    protected ConsoleView getView() {
        return menu.getView();
    }

    public String description() {
        return description;
    }
}
