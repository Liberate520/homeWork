package Home.model.human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private int age;
    protected Human mother;
    protected Human father;
    protected List<Human> childrens;

    public Human(String name, int age, Human father, Human mother) {
    }


    public void setMother(Human mother) { this.mother = mother; }
    public void setFather(Human father) {
        this.father = father;

    }
    public  void setChildrens(List<Human> childrens) { this.childrens = childrens; }

    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Human(String name, int age, Human father, Human mother, ArrayList<Human> children, ArrayList<Human> sisters, ArrayList<Human> brothers) {
        this(name, age, father, mother);
        if (children != null) {
            this.childrens = new ArrayList<>(children);
        } else {
            this.childrens = new ArrayList<>();
        }

    }


    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return name  +
                ", age: " + age +
                "\n";
    }
}
