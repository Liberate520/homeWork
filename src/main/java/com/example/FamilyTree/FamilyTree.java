package com.example.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private Human human;
    private List<Human> parents;
    private List<Human> children;

    public FamilyTree() {
        this.human = new Human();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addParents(Human human) {
        int diff = this.human.getBirthday().getYear() - human.getBirthday().getYear();
        System.out.println("разница в возрасте = " + diff);
        if (parents.size() == 0 && diff >= 15) {
            parents.add(human);
        } else if ((parents.size() == 1 && diff >= 15) && (parents.get(0).getGender() == Gender.male) && (human.getGender() == Gender.female)) {
            parents.add(human);
        } else if ((parents.size() == 1 && diff >= 15) && (parents.get(0).getGender() == Gender.female) && (human.getGender() == Gender.male)) {
            parents.add(human);
        } else {
            System.out.println("не может быть родителем этому человеку");
        }
    }

    public void addChildren(Human human) {
        int diff = human.getBirthday().getYear() - this.human.getBirthday().getYear();
        if (diff >= 15) {
            children.add(human);
        } else {
            System.out.println("не может быть ребенком этому человеку");
        }
    }
}
