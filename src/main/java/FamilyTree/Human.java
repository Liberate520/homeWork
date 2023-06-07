package FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private String surname;
    private LocalDate birthdate;
    private LocalDate deathdate;
    private Gender sex;
    private Human father;
    private Human mother;
    private List<Human> children;

    public void setFather(Human father) {
        this.father = father;
        father.addChild(this);
    }

    public void setMother(Human mother) {
        this.mother = mother;
        mother.addChild(this);
    }

    public void addChild(Human children) {
        this.children.add(children);
    }

    public String getName() {
        return name;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human (String name, String surname, LocalDate birthdate, Gender sex){
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.sex = sex;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Human: " + "name=" + name + ", surname=" + surname + ", birthdate=" + birthdate + ", sex=" + sex;
    }
}
