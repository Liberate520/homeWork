package view.consoleUI.menu.recordMenu.commands;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.mainMenu.commands.Command;

/**
 * Класс GetParents представляет команду получения родителей человека из дерева в меню консольного пользовательского интерфейса (UI).
 * Реализует интерфейс Sortedable.
 */
public class GetChildren implements Command {
    private ConsoleUI consoleUI;

    /**
     * Создает новый объект GetParents.
     *
     * @param consoleUI объект ConsoleUI, используемый для получения родителей человека из дерева
     */
    public GetChildren(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получить детей человека из дерева";
    }

    @Override
    public void execute() {
        consoleUI.getChildren();

    }
}