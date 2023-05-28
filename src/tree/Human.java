package tree;

import java.util.HashSet;
import java.util.Set;

import static tree.Gender.*;

public class Human {
    private String name;
    private Gender gender;
   // private String gender;
    private Human father;
    private Human mother;
    private Set<Human> children;

    public Human(String name, Gender gender, Human father, Human mother) {

        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new HashSet<>();
        if (mother != null) mother.AddChild(this);
        if (father != null) father.AddChild(this);
    }

    public Human(String name, Gender gender, Human human) {
            this(name, gender, null, null);
            addParent(human);
    }

    public Human(String name, Gender gender) {
        this(name, gender, null);
    }
    public String getName() {
        return name;
    }
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

    public void AddChild(Human human){
        if (human != null) {
            children.add(human);
            human.addParent(this);
        }
    }

    public String GetParent() {
        if(father == null & mother == null) return name + " (Отец: " + "NULL" + ", Мать: " + "NULL" + ")";
        else if (father == null) return name + " (Отец: " + "NULL" + ", Мать: " + mother.name + ")";
        else if (mother == null) return name + " (Отец: " + father.name + ", Мать: " + "NULL" + ")";
        else return name + " (Отец: " + father.name + ", Мать: " + mother.name + ")";
    }

    public String GetChild() {
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
}