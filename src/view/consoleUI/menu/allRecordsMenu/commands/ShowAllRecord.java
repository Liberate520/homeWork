package view.consoleUI.menu.allRecordsMenu.commands;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.mainMenu.commands.Command;

/**
 * Класс getAllRecord представляет команду показа всех записей в древе в меню консольного пользовательского интерфейса (UI).
 * Реализует интерфейс Sortedable.
 */
public class ShowAllRecord implements Command {

    private ConsoleUI consoleUI;

    /**
     * Создает новый объект getAllRecord.
     *
     * @param consoleUI объект ConsoleUI, используемый для показа всех записей в древе
     */
    public ShowAllRecord(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Показать все записи в древе";
    }

    @Override
    public void execute() {
        consoleUI.showAllRecord();

    }
}
