package fam_tree;

import java.time.LocalDate;

public class HumanBuild {

    public Human build(String name, Gender gender, LocalDate birthDay){
        Human human = new Human(name, gender, birthDay);
        return human;
    }
}
