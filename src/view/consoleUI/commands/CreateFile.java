package view.consoleUI.commands;

import view.consoleUI.menu.CreationFileMenu;
import view.consoleUI.menu.Menu;

/**
 * Команда для создания файла
 */
public class CreateFile extends Command {
    @Override
    public String getDescription() {
        return "Создать файл";
    }

    @Override
    public void execute(Menu menu) {
        menu.stop();
        CreationFileMenu creationFileMenu = new CreationFileMenu("Меню создания файла", false);
        creationFileMenu.run();
    }
}
