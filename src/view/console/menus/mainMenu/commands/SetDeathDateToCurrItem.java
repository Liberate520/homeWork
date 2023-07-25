package view.console.menus.mainMenu.commands;

import view.console.ConsoleUI;

public class SetDeathDateToCurrItem extends Command {
    public SetDeathDateToCurrItem(ConsoleUI consoleUI) {
        super("установить текущему человеку дату смерти", consoleUI);
    }

    public void execute() {
        consoleUI.setDeathDateToCurrItem();
    }
}