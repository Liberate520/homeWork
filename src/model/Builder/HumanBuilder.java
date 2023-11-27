package model.Builder;

import model.human.Gender;
import model.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private int curId=1;
    public Human build(String lastname, String name, LocalDate birthday, LocalDate dayOfDeath, Gender gender){
            return new Human(curId++, lastname, name, birthday, dayOfDeath, gender);
        }
    }

