package view.menu.commands;

import view.ConsoleUI;

/**
 * Класс Finish представляет команду выхода из программы с сохранением в меню консольного пользовательского интерфейса (UI).
 * Реализует интерфейс Command.
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
        return "Выйти из программы (Сохранить)";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}
