package view.console.menus.mainMenu.commands;

import view.console.ConsoleUI;

public class GetCurrentItemFullInfo extends Command {
    public GetCurrentItemFullInfo(ConsoleUI consoleUI) {
        super("отобразить текущего человека", consoleUI);
    }

    public void execute() {
        consoleUI.getCurrentItemFullInfo();
    }
}