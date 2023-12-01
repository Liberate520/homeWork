package ru.gb.family_tree.model.builder;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

public class HumanBuilder {

    public Human build (String lastname, String name, Gender gender) {
        Human human = new Human(lastname, name, gender);
        return human;
    }
}
