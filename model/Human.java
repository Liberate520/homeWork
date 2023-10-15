package homeWork3.model;

import homeWork3.model.PetFamily;

import java.io.Serial;

public class Human extends PetFamily {
    @Serial
    private static final long serialVersionUID = 1L;

    public Human(String name, String gender, int age) {
        super(name, gender, age);
    }

    public Human(String name, String gender, int age, PetFamily mother, PetFamily father) {
        super(name, gender, age, mother, father);
    }
}