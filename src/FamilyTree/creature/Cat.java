package FamilyTree.creature;

import java.time.LocalDate;

public class Cat extends Creature {
    public Cat(String name, Gender gender, LocalDate dataBirth, LocalDate dataDeath, Human mother, Human father) {
        super(name, gender, dataBirth, dataDeath, mother, father);
    }

    public Cat(String name, Gender gender, LocalDate dataBirth) {
        super(name, gender, dataBirth);
    }

    public Cat(String name, Gender gender, LocalDate dataBirth, Human father, Human mother) {
        super(name, gender, dataBirth, father, mother);
    }
}
