package FamilyTree;

import java.util.HashSet;
import java.util.Set;

public class Human {
    String name;
    String gender;
    Human father;
    Human mother;
    Set<Human> children;

    public Human(String name, String gender, Human father, Human mother) {

        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new HashSet<>();
        if (mother != null) mother.AddChild(this);
        if (father != null) father.AddChild(this);
    }

    public Human(String name, String gender, Human human) {
            this(name, gender, null, null);
            AddParent(human);
    }

    public Human(String name, String gender) {
        this(name, gender, null);
    }

    public void AddParent(Human human) {
        if (human != null) {
            if (human.gender == "man") {
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
            human.AddParent(this);
        }
    }

    public String GetParent() {
        if(father == null & mother == null) return name + " (Отец: " + "NULL" + ", Мать: " + "NULL" + ")";
        else if (father == null) return name + " (Отец: " + "NULL" + ", Мать: " + mother.name + ")";
        else if (mother == null) return name + " (Отец: " + father.name + ", Мать: " + "NULL" + ")";
        else return name + " (Отец: " + father.name + ", Мать: " + mother.name + ")";
    }

    public String GetChild() {
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