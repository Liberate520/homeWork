package view.menu.mainMenu;

import view.ConsoleUI;
import view.menu.BaseMenu;
import view.menu.mainMenu.commands.*;

import java.util.Arrays;

/**
 * Класс MainMenu представляет главное меню консольного пользовательского интерфейса (UI).
 * Содержит список доступных команд и предоставляет методы для выполнения выбранной команды и получения размера меню.
 */
public class MainMenu extends BaseMenu {

    public MainMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new AddRecord(consoleUI),
                new GetRecord(consoleUI),
                new GetParents(consoleUI),
                new ShowAllRecord(consoleUI),
                new SortMenu(consoleUI),
                new Finish(consoleUI)));
    }
}
