package view.menu.commands;

import view.ConsoleUI;

/**
 * Класс SortingTrees представляет команду сортировки списка в меню консольного пользовательского интерфейса (UI).
 * Реализует интерфейс Command.
 */
public class SortingTrees implements Command {

    private ConsoleUI consoleUI;

    /**
     * Создает новый объект SortingTrees.
     *
     * @param consoleUI объект ConsoleUI, используемый для выполнения сортировки списка
     */
    public SortingTrees(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }


    @Override
    public String getDescription() {
        return "Сортировка списка";
    }

    @Override
    public void execute() {
        consoleUI.sortTree();
    }
}
