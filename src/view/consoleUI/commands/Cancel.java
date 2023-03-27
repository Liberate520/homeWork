package view.consoleUI.commands;

import view.consoleUI.menu.Menu;

/**
 * Команда Отмена
 */
public class Cancel extends Command {
    @Override
    public String getDescription() {
        return "Отмена";
    }

    @Override
    public void execute(Menu menu) {
        menu.stop();
    }
}
