package ru.geekbrains.family_tree.view.validations;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Проверка соответствия даты формату "ДД-ММ-ГГГГ".
 */
public class IsDate extends Validation {
    
    public IsDate(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        inputError = "Дата введена неверно.";
    }

    /**
     * Возвращает true, если последовательность в формате "ДД-ММ-ГГГГ" является
     * датой, и возвращает false и выводит информационное сообщение, если не
     * является.
     */
    public boolean validate(String string) {
        String [] date = string.split("-");
        int dayInMonth = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        if (year > LocalDate.now().getYear()) {
            consoleUserInterface.print(inputError);
            return false;
        }
        Calendar calendar = new GregorianCalendar(year, month, dayInMonth);
        calendar.setLenient(false);
        try {
            calendar.set(year, month -1, dayInMonth);
            calendar.getTime();
            return true;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            consoleUserInterface.print(String.format("%s\n", inputError));
            return false;
        }
    }

}
