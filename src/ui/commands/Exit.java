package ui.commands;

import ui.ConsoleView;

public class Exit extends MenuCommand {

    public Exit(ConsoleView view) {
        super(view, "Выход");
    }

    public void run() {
        super.view.exit();
    }
}
