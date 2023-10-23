package homeWork3.core.models;

import homeWork3.core.mvp.Model;

import java.io.Serial;

public class Human extends Model {
    @Serial
    private static final long serialVersionUID = 1L;

    public Human(String name, String gender, int age) {
        super(name, gender, age);
    }

}