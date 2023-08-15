package ru.geekbrains.family_tree.view.actions;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Действие, которое выбирается через пользовательский интерфейс.
 */
public abstract class Action {

    /**
     * Название действия, ввод которого выбирает его.
     */
    String name;

    /**
     * Описание действия.
     */
    String description;

    /**
     * Пользовательский интерфейс, через который выбирается действие.
     */
    ConsoleUserInterface consoleUserInterface;

    public Action(ConsoleUserInterface consoleUserInterface) {
        this.consoleUserInterface = consoleUserInterface;
    }

    /**
     * Возвращает имя действия.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает описание действия.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Выполняет действие.
     */
    public abstract void perform();
    
}
