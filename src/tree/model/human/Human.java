package tree.model.human;

import tree.model.familyTree.TreeItem;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import static tree.model.human.Gender.*;

public class Human implements Serializable, Comparable<Human>, TreeItem<Human> {
    private String name;
    private Gender gender;
    private Human father;
    private Human mother;
    private Set<Human> children;

    public Human(String name, Gender gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new HashSet<>();
    }

    public Human(String name, Gender gender, Human human) {
            this(name, gender, null, null);
            addParent(human);
    }

    public Human(String name, Gender gender) {
        this(name, gender, null);
    }
    @Override
    public String getName() { return name; }
    public Gender getGender() { return gender;}
    @Override
    public Human getFather() { return father; }
    public void setFather(Human father) { this.father = father; }
    @Override
    public Human getMother() { return mother; }
    public void setMother(Human mother) { this.mother = mother; }
    public void setChildren(Human child) { children.add(child); }

    public void addParent(Human human) {
        if (human != null) {
            if (human.gender == man) {
                if (father != null) father.children.remove(this);
                father = human;
            } else {
                if (mother != null) mother.children.remove(this);
                mother = human;
            }
            human.children.add(this);
        }
    }
    @Override
    public void addChild(Human human){
        if (human != null) {
            children.add(human);
            human.addParent(this);
        }
    }

    public String getParent() {
        if(father == null & mother == null) return "(Отец: " + "NULL" + ", Мать: " + "NULL" + ")";
        else if (father == null) return "(Отец: " + "NULL" + ", Мать: " + mother.name + ")";
        else if (mother == null) return "(Отец: " + father.name + ", Мать: " + "NULL" + ")";
        else return "(Отец: " + father.name + ", Мать: " + mother.name + ")";
    }
    @Override
    public Set<Human> getChildrenList() {
        return this.children;
    }
    @Override
    public String getChild() {
        if (children.isEmpty()) return name + " 'child' ---> нет";
        StringBuilder st = new StringBuilder();
        for (Human name : children) {
            st.append("\n\tИмя: " + name.name + " Пол: " + name.gender);
        }
        return name + " 'child' --->" + st.toString();
    }

    @Override
    public String toString() {
        return  String.format("%s, пол: %s %s, (детей: %d)", name, gender, getParent(), children.size());
    }

    @Override
    public int compareTo(Human human) {
        return name.compareTo(human.getName());
    }
}