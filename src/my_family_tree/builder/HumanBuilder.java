package my_family_tree.builder;

import my_family_tree.human.Gender;
import my_family_tree.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    public Human build(String name, Gender gender, LocalDate birthDay){
        Human human = new Human(name, gender, birthDay);
        return human;
    }
}
