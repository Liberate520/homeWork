package view.console.menus.mainMenu.commands;

import view.console.ConsoleUI;

public class SetBirthDateToCurrItem extends Command {
    public SetBirthDateToCurrItem(ConsoleUI consoleUI) {
        super("установить текущему человеку дату рождения", consoleUI);
    }

    public void execute() {
        consoleUI.setBirthDateToCurrItem();
    }
}