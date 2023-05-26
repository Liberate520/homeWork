package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Human {
    String name;
    String gender;
    Human father;
    Human mother;
    List<Human> children;

    public Human(String name, String gender, Human father, Human mother) {

        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
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
            if (human.gender == "man") this.father = human;
            else this.mother = human;
        }
    }

    public void AddChild(Human human){
        this.children.add(human);

    }

@Override
    public String toString() {
        return "Имя: " + name + ", Пол: " + gender;// + " (Отец: " + father + ", Мать: " + mother + ")";
    }

}