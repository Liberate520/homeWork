package view.menu.commands;

import view.ConsoleUI;

/**
 * Класс GetParents представляет команду получения родителей человека из дерева в меню консольного пользовательского интерфейса (UI).
 * Реализует интерфейс Command.
 */
public class GetParents implements Command {
    private ConsoleUI consoleUI;

    /**
     * Создает новый объект GetParents.
     *
     * @param consoleUI объект ConsoleUI, используемый для получения родителей человека из дерева
     */
    public GetParents(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получить родителей человека из дерева";
    }

    @Override
    public void execute() {
        consoleUI.getParents();

    }
}