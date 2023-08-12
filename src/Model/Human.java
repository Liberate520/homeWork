package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Human extends HouseHold implements Serializable{

    public Human(String name, int age, Gender gender){
        super(name, age, gender);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}