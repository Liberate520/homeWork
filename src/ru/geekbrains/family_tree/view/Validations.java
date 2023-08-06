package ru.geekbrains.family_tree.view;

import java.util.ArrayList;
import java.util.Arrays;

import ru.geekbrains.family_tree.view.validations.*;

/**
 * Проверки действительности значений.
 */
public class Validations {
    
    private ArrayList<Validation> validations;

    public Validations(ConsoleUserInterface consoleUserInterface) {
        validations = new ArrayList<>(Arrays.asList(new IsNotEmpty(consoleUserInterface),
                                                    new IsSex(consoleUserInterface),
                                                    new IsDate(consoleUserInterface)));
    }

    /**
     * Возвращает проверку.
     */
    public Validation getValidation(int index) {
        return validations.get(index);
    }

}
