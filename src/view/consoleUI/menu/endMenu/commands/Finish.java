package view.consoleUI.menu.endMenu.commands;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.mainMenu.commands.Command;

/**
 * Класс Finish представляет команду выхода из программы с сохранением в меню консольного пользовательского интерфейса (UI).
 * Реализует интерфейс Sortedable.
 */
public class Finish implements Command {

    private ConsoleUI consoleUI;

    /**
     * Создает новый объект Finish.
     *
     * @param consoleUI объект ConsoleUI, используемый для завершения программы с сохранением
     */
    public Finish(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Выйти из программы";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}
