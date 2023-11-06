package ru.gb.f_tree.builder;

import ru.gb.f_tree.human.Gender;
import ru.gb.f_tree.human.Human;

public class HumanBuilder {

    public Human build(String lastname, String name, Gender gender) {
        return new Human(lastname, name, gender);
    }
}