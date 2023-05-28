package com.example.FamilyTree;

import com.example.VendingMachine.Product;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private Human human;
    private List<Human> parents;
    private List<Human> children;

    public FamilyTree(Human human) {
        this.human = human;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addParents(Human human) {
        int diff = this.human.getBirthday().getYear() - human.getBirthday().getYear();
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

    public String getFamilyTree() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human1 : parents) {
            stringBuilder.append(human1);
        }

        for (Human human1 : children) {
            stringBuilder.append(human1);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "\nFamilyTree for human:" + human + "\n" +
                ((parents.size()>0) ? ("parents: " + parents + "\n" ) : ("")) +
                ((children.size()>0) ? ("children: " + children) : ("")) + "\n";
    }
}
