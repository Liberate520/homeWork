package ru.gb.family_tree.builder;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;

public class HumanBuilder {


    public Human build (String lastname, String name, Gender gender) {
        Human human = new Human(lastname, name, gender);
        return human;
    }
}
