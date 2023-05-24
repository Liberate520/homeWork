package model;

import java.io.*;

public class Service {
    private FamilyTree tree;

    public Service(FamilyTree tree) {
        this.tree = tree;
    }

    public Service() {
        this(new FamilyTree());
    }

    public void addHuman(String name, int age, String gender, String motherName, String fatherName) {
        Gender gender1 = Gender.male;
        if (gender.equals("ж")) {
            gender1 = Gender.female;
        }

        Human mother = null;
        Human father = null;

        if (tree.findHumanByName(motherName) != null) {
            mother = (Human) tree.findHumanByName(motherName);
        }
        if (tree.findHumanByName(fatherName) != null) {
            father = (Human) tree.findHumanByName(fatherName);
        }

        Human newHuman = new Human(name, age, gender1, mother, father);

        tree.addHuman(newHuman);
    }

    public String showAllRelatives() {
        return tree.showAllRelatives();
    }

    public String findHumanByName(String name) {
        Human human = null;

        if (tree.findHumanByName(name) != null) {
            human = (Human) tree.findHumanByName(name);
            return human.toString();
        }

        return "Такого человека не существует";
    }

    public void showKids(String name) {
        Human human = null;
        if (tree.findHumanByName(name) != null) {
            human = (Human) tree.findHumanByName(name);
            human.showKids();
        }
    }

    public void findSiblings(String name) {
        Human human = null;
        if (tree.findHumanByName(name) != null) {
            human = (Human) tree.findHumanByName(name);
            human.findSiblings();
        }
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }


}
