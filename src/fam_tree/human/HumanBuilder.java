package fam_tree.human;

import java.time.LocalDate;
public class HumanBuilder {

    public Human build(String name, Gender gender, LocalDate birthDay){
        return new Human(name, gender, birthDay);
    }
}

