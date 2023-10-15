package homeWork3.model;

import java.io.Serial;

public class Human extends PetFamily {
    @Serial
    private static final long serialVersionUID = 1L;

    public Human(String name, String gender, int age) {
        super(name, gender, age);
    }

}