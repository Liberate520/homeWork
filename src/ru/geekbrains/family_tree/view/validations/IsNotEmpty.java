package ru.geekbrains.family_tree.view.validations;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Проверка строки на отсутствие пустого значения.
 */
public class IsNotEmpty extends Validation {
    
    public IsNotEmpty(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        inputError = "Данные введены неверно.";
    }

    /**
     * Возвращает true, если строка не является пустой, и возвращает false и 
     * выводит информационное сообщение, если является.
     */
    public boolean validate(String string) {
        if (string.isEmpty()) {
            consoleUserInterface.print(String.format("%s\n", inputError));
            return false;
        }
        return true;
    }

}
