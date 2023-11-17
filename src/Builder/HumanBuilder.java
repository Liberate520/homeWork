package Builder;

import human.Gender;
import human.Human;
import tree.FamilyTree;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class HumanBuilder {
    private int curId;

    public Human build(String lastname, String name, LocalDate birthday, LocalDate dayOfDeath, Gender gender, Human parent1, Human parent2){
            return new Human(curId++, lastname, name, birthday, dayOfDeath, gender, parent1, parent2);
        }
    }

