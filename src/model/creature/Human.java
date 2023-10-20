package model.creature;

import java.time.LocalDate;


public class Human extends Creature {

    public Human(String name, Gender gender, LocalDate dataBirth, LocalDate dataDeath, Human mother, Human father) {
        super(name, gender, dataBirth, dataDeath, mother, father);
    }

    public Human(String name, Gender gender, LocalDate dataBirth) {
        super(name, gender, dataBirth);
    }

    public Human(String name, Gender gender, LocalDate dataBirth, Human father, Human mother) {
        super(name, gender, dataBirth, father, mother);
    }

}



