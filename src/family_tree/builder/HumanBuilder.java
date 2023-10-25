package family_tree.builder;

import java.io.Serializable;
import java.time.LocalDate;

import family_tree.human.Human;
import family_tree.human.types_enum.Gender;

public class HumanBuilder implements Serializable{

    public Human build(String name, LocalDate birthDay, LocalDate deadDay, Human mother, Human father, Gender gender){
        Human human = new Human(name, birthDay, deadDay, mother, father, gender);
        return human;
    }
}
