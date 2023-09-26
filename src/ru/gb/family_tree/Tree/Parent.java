package ru.gb.family_tree.Tree;

import ru.gb.family_tree.Family.Gender;
import ru.gb.family_tree.Family.Human;

import java.util.List;

public class Parent extends Human{
    private List<Human> children;
    private Human spouse;
    public Parent(String name, Gender gender, String dateOfBirth, String dateOfDeath,
                  List<Human> children, Human spouse) {
        super(name, gender, dateOfBirth, dateOfDeath);
        this.children = children;
        this.spouse = spouse;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getSpouse() {
        return spouse;
    }


    @Override
    public String toString() {
        return super.toString() + "\n" + "Spouse: " + spouse + ", children: " + children;
    }
}
