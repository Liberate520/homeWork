package src.model;

import java.time.LocalDate;
import java.time.Period;
// Класс LocalDate из пакета java.time предназначен для работы с датами. Функционал этого класса позволяет создавать 
// даты и изменять их, добавляя и отнимая необходимое количество дней/месяцев/лет.
// https://metanit.com/java/tutorial/12.3.php

public class AgeCalculator {
    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}