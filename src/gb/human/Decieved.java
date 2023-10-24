package ru.gb.human;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadPoolExecutor;

public class Decieved extends Human {
    private LocalDate deathDate;

    public Decieved(String name, Gender gender, Human father, Human mother, String bornDate, String deathDate) {
        super(name, gender, father, mother, bornDate);
        this.deathDate = LocalDate.parse(deathDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public Decieved(String name, Gender gender, String bornDate, String deathDate) {
        super(name, gender, bornDate);
        this.deathDate = LocalDate.parse(deathDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Override
    public String toString() {
        return super.toString() + "Death date: " + deathDate +"\n";
    }

    //    @Override
//    public String toString() {
//        return super + "Death date: " + deathDate;
//    }
}
