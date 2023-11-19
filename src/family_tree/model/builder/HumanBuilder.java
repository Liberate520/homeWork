package family_tree.model.builder;

import java.io.Serializable;
import java.time.LocalDate;

import family_tree.model.human.Human;
import family_tree.model.human.types_enum.Gender;

public class HumanBuilder implements Serializable{

    public Human build(String name, LocalDate birthDay, LocalDate deadDay, Gender gender){
        Human human = new Human(name, birthDay, deadDay, gender);
        return human;
    }
}
