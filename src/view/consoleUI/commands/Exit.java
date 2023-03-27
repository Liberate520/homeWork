package view.consoleUI.commands;

import view.consoleUI.menu.Menu;

/**
 * Команда Выход из программы
 */
public class Exit extends Command{
    @Override
    public void execute(Menu menu) {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Выход";
    }
}
