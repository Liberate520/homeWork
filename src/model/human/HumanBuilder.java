package model.human;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanBuilder implements Serializable {
    public Human build(String name, Gender gender, LocalDate localDate){
            return new Human(name,gender,localDate);
    }

}
