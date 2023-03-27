package view.consoleUI.commands;

import view.consoleUI.menu.FlipMenu;
import view.consoleUI.menu.Menu;
/**
 * Команда для перехода на предыдущую страницу в FlipMenu
 */
public class PreviousPage extends Command{
    @Override
    public String getDescription() {
        return "Предыдущая страница";
    }

    @Override
    public void execute(Menu menu) {
        ((FlipMenu) menu).decrementPage();
    }
}
