package view.consoleUI.menu.mainMenu.commands;

import model.members.Human;
import view.consoleUI.ConsoleUI;

import java.util.List;

/**
 * Класс getAllRecord представляет команду показа всех записей в древе в меню консольного пользовательского интерфейса (UI).
 * Реализует интерфейс Sortedable.
 */
public class GetAllRecord implements Command {

    private ConsoleUI consoleUI;

    /**
     * Создает новый объект getAllRecord.
     *
     * @param consoleUI объект ConsoleUI, используемый для показа всех записей в древе
     */
    public GetAllRecord(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получить все записи в древе";
    }

    @Override
    public void execute() {
        consoleUI.runRecordsMenu(consoleUI.getAllRecord());
    }


}
