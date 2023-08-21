package Model.BaseCharacter;

import java.io.Serializable;

public class Human extends BaseCharacter implements Serializable{

    public Human(String name, int age, Gender gender){
        super(name, age, gender);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}