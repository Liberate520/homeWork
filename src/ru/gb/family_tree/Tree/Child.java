package ru.gb.family_tree.Tree;

import ru.gb.family_tree.Family.Gender;
import ru.gb.family_tree.Family.Human;

import java.util.List;

public class Child extends Parent{
    private Human mother, father;
    public Child(String name, Gender gender, String dateOfBirth, String dateOfDeath,
                  Human mother, Human father, List<Human> children, Human spouse){
        super(name, gender, dateOfBirth, dateOfDeath, children, spouse);
        this.mother = mother;
        this.father = father;
    }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Mother: " + mother + ", Father: " + father;
    }
}
