package view.consoleUI.commands;

import view.consoleUI.menu.FlipMenu;
import view.consoleUI.menu.Menu;

/**
 * Команда для перехода на следующую страницу в FlipMenu
 */
public class NextPage extends Command{
    @Override
    public String getDescription() {
        return "Следующая страница";
    }
    @Override
    public void execute(Menu menu) {
        ((FlipMenu) menu).incrementPage();
    }
}
