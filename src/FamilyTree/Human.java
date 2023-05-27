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
                if (this.father != null) this.father.children.remove(this);
                this.father = human;
            } else {
                if (this.mother != null) this.mother.children.remove(this);
                this.mother = human;
            }
            human.children.add(this);
        }
    }

    public void AddChild(Human human){
        if (human != null) {
            this.children.add(human);
            human.AddParent(this);
        }
    }

    public String GetParent() {
        if(father == null & mother == null) return this.name + " (Отец: " + "NULL" + ", Мать: " + "NULL" + ")";
        else if (father == null) return this.name + " (Отец: " + "NULL" + ", Мать: " + mother.name + ")";
        else if (mother == null) return this.name + " (Отец: " + father.name + ", Мать: " + "NULL" + ")";
        else return this.name + " (Отец: " + father.name + ", Мать: " + mother.name + ")";
    }

    public String GetChild() {
        StringBuilder st = new StringBuilder();
        for (Human name : children) {
            st.append("\tИмя: " + name.name + " Пол: " + name.gender + "\n");
        }
        return this.name + " 'child' --->\n" + st.toString();
    }

@Override
    public String toString() {
        return "Имя: " + name + ", Пол: " + gender;
    }
}