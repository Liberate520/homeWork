package com.example.FamilyTree.DataForTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Family<T extends FamilyTreeInterface> implements Serializable, FamilyTreeInterface {
    private T human;
    private List<T> parents;
    private List<T> children;

    public Family(T human) {
        this.human = human;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addParents(T human) {
        int diff = this.human.getBirthday().getYear() - human.getBirthday().getYear();
        if (parents.size() == 0 && diff >= human.getPuberty()) {
            parents.add(human);
        } else if ((parents.size() == 1 && diff >= human.getPuberty()) && (parents.get(0).getGender() == Gender.male) && (human.getGender() == Gender.female)) {
            parents.add(human);
        } else if ((parents.size() == 1 && diff >= human.getPuberty()) && (parents.get(0).getGender() == Gender.female) && (human.getGender() == Gender.male)) {
            parents.add(human);
        } else {
            System.out.println("не может быть родителем этому объекту");
        }
    }

    public void addChildren(T human) {
        int diff = human.getBirthday().getYear() - this.human.getBirthday().getYear();
        if (diff >= human.getPuberty()) {
            children.add(human);
        } else {
            System.out.println("не может быть ребенком этому человеку");
        }
    }

    public T getHuman() {
        return human;
    }

    public List<T> getParents() {
        return parents;
    }

    public List<T> getChildren() {
        return children;
    }

    @Override
    public Gender getGender() {
        return human.getGender();
    }

    @Override
    public Date getBirthday() {
        return human.getBirthday();
    }

    @Override
    public String getName() {
        return human.getName();
    }

    @Override
    public int getPuberty() {
        return human.getPuberty();
    }

    @Override
    public String toString() {
        String parent = "parents: \n";
        if (parents.size()>0) {
            for (FamilyTreeInterface parent1 : parents) {
                parent = parent + ((parent1.getGender() == Gender.female) ? "mother " : "father ") + parent1 + "\n";
            }
        } else { parent = "";}
        String child = "children: \n";
        if (children.size()>0) {
            for (FamilyTreeInterface children1 : children) {
                child = child + ((children1.getGender() == Gender.female) ? "daughter " : "son ") + children1 + "\n";
            }
        } else { child = "\n";}

        return "\nFamilyTree for object: " + human + "\n" + parent + child;
    }
}
