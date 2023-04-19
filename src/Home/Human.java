package Home;

import java.io.Serializable;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private int age;
    protected Human mother;
    protected Human father;
    protected List<Human> sisters;
    protected List<Human> brothers;
    protected List<Human> childrens;


    public void setMother(Human mother) { this.mother = mother; }
    public void setFather(Human father) { this.father = father; }
    public void setChildrens(List<Human> childrens) { this.childrens = childrens; }
    public void setSisters(List<Human> sisters) { this.sisters = sisters; }
    public void setBrothers(List<Human> brothers) { this.brothers = brothers; }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getSisters() {
        return sisters;
    }

    public List<Human> getBrothers() {
        return brothers;
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
