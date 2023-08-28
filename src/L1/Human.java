package L1;

import java.util.ArrayList;
import java.util.List;

public class Human {

    private int ID;
    private int age;
    private String name;
    private String birthday;
    private Gender gender;

    private Human father;
    private Human mother;
    List<Human> children;

    public Human(int ID, int age, String name, String birthday, Gender gender, Human father, Human mother) {
        this.ID = ID;
        this.age = age;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(int ID, int age, String name, String birthday, Gender gender) {
        this.ID = ID;
        this.age = age;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        children = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void addChild(Human child){
        children.add(child);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public void setFather(Human father) {
        this.father = father;
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

    @Override
    public String toString() {
        return "Human{" +
                "ID=" + ID +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", \n   father=" + father.name +
                ", \n   mother=" + mother.name +
                ", \n   children=" + children +
                '}';
    }
}
