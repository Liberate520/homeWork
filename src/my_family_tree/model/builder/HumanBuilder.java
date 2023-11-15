package my_family_tree.model.builder;

import my_family_tree.model.human.Gender;
import my_family_tree.model.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    public Human build(String name, Gender gender, LocalDate birthDay){
        Human human = new Human(name, gender, birthDay);
        return human;
    }
}
