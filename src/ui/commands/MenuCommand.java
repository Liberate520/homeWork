package ui.commands;

import ui.ConsoleView;

public abstract class MenuCommand {
    ConsoleView view;
    public String description;

    MenuCommand(ConsoleView view, String description) {
        this.view = view;
        this.description = description;
    }

    public void run() {
    };
}
