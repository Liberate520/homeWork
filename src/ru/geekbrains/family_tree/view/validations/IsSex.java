package ru.geekbrains.family_tree.view.validations;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Проверка соответствия пола мужскому или женскому.
 */
public class IsSex extends Validation {
    
    public IsSex(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        inputError = "Пол введён неверно.";
    }

    /**
     * Возвращает true, если пол является мужским или женским, и возвращает
     * false и выводит информационное сообщение, если не является.
     */
    public boolean validate(String sex) {
        if (sex.equals("male") || sex.equals("female")) {
            return true;
        }
        consoleUserInterface.print(String.format("%s\n", inputError));
        return false;
    }
}
