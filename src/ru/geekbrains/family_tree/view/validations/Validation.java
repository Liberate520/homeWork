package ru.geekbrains.family_tree.view.validations;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Проверка действительности значения.
 */
public abstract class Validation {
    
    /**
     * Информационное сообщение.
     */
    String inputError;

    ConsoleUserInterface consoleUserInterface;

    public Validation(ConsoleUserInterface consoleUserInterface) {
        this.consoleUserInterface = consoleUserInterface;
    }

    /**
     * Возвращает true, если значение действительное, и возвращает false и
     * выводит информационное сообщение, если не действительное.
     */
    public abstract boolean validate(String string);

}
