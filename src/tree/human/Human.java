package tree.human;

import tree.familyTree.TreeItem;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import static tree.human.Gender.*;

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
    public String getName() {
        return name;
    }
    @Override
    public Human getFather() { return father; }
    @Override
    public Human getMother() { return mother; }

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
        if(father == null & mother == null) return name + " (Отец: " + "NULL" + ", Мать: " + "NULL" + ")";
        else if (father == null) return name + " (Отец: " + "NULL" + ", Мать: " + mother.name + ")";
        else if (mother == null) return name + " (Отец: " + father.name + ", Мать: " + "NULL" + ")";
        else return name + " (Отец: " + father.name + ", Мать: " + mother.name + ")";
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
        return "Имя: " + name + ", Пол: " + gender;
    }

    @Override
    public int compareTo(Human human) {
        return name.compareTo(human.getName());
    }
}