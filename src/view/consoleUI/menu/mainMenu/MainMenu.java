package view.consoleUI.menu.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.Menu;
import view.consoleUI.menu.mainMenu.commands.*;
import view.consoleUI.menu.recordMenu.commands.GetChildren;
import view.consoleUI.menu.recordMenu.commands.GetParents;

import java.util.Arrays;

/**
 * Класс MainMenu представляет главное меню консольного пользовательского интерфейса (UI).
 * Содержит список доступных команд и предоставляет методы для выполнения выбранной команды и получения размера меню.
 */
public class MainMenu extends Menu {

    public MainMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new AddRecord(consoleUI),
                new GetRecord(consoleUI),
                new ShowAllRecord(consoleUI),
                new SortedTree(consoleUI),
                new Finish(consoleUI)));
    }
}
