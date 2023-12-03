package model.builder;

import model.human.Gender;
import model.human.Human;

public class HumanBuilder {
    public Human build (String name, String surname, Gender gender) {
        Human human = new Human(name, surname, gender);
        return human;
    }
}
