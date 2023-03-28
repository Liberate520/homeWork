

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private int date;
    Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children = new ArrayList<>();

    public Human(String name, Gender gender, int date, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.father = father;
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public Human setFather(Human father) {
        this.father = father;
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    // public void addChildren(Human human) {
    //     if (this.children == null) {
    //         this.children = new ArrayList<>();
    //     }
    //     this.children.add(human);
    // }

    @Override
    public String toString() {
        return String.format("\nИмя : %s; пол : %s; дата смерти : %d отец : %s мать : %s дети : %s \n",
                name, gender, date, father, mother, children);
    }
}
