package com.example.FamilyTree.DataSource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HumanFamily implements Serializable {
    private Human human;
    private List<Human> parents;
    private List<Human> children;

    public HumanFamily(Human human) {
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

    @Override
    public String toString() {
        String parent = "parents: \n";
        if (parents.size()>0) {
            for (Human parent1 : parents) {
                parent = parent + ((parent1.getGender() == Gender.female) ? "mother " : "father ") + parent1 + "\n";
            }
        } else { parent = "";}
        String child = "children: \n";
        if (children.size()>0) {
            for (Human children1 : children) {
                child = child + ((children1.getGender() == Gender.female) ? "daughter " : "son ") + children1 + "\n";
            }
        } else { child = "\n";}

        return "\nFamilyTree for human: " + human + "\n" + parent + child;
    }

    public Human getHuman() {
        return human;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }
}
