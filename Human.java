package homeWork3;

import homeWork3.model.MainFamily;

import java.io.Serial;

public class Human extends MainFamily {
    @Serial
    private static final long serialVersionUID = 1L;

    public Human(String name, String gender, int age) {
        super(name, gender, age);
    }

    public Human(String name, String gender, int age, MainFamily mother, MainFamily father) {
        super(name, gender, age, mother, father);
    }
}