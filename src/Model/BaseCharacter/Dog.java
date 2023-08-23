package Model.BaseCharacter;

import java.io.Serializable;

public class Dog extends BaseCharacter implements Serializable {
    public Dog(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
