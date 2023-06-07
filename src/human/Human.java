package human;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Human implements Serializable {
    private String NAME;
    private Year yearOfBirth;
    private String sex;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, String sex, int yearOfBirth) {
        this.NAME = name;
        this.yearOfBirth = Year.of(yearOfBirth);
        this.sex = sex;
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    public String getNAME() {
        return NAME;
    }

    public Year getYearOfBirth() {
        return yearOfBirth;
    }

    public String getSex() {
        return sex;
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

    public void addChild(Human child) {
        this.children.add(child);
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        ArrayList<String> temp = new ArrayList<>();
        for (Human child : children) {
            temp.add(child.getNAME());
        }
        return "trees.Human{" +
                "Name='" + NAME + '\'' +
                ", date of brith=" + yearOfBirth +
                ", father=" + Optional.ofNullable(father).map(Human::getNAME).orElse("unknown") +
                ", mother=" + Optional.ofNullable(mother).map(Human::getNAME).orElse("unknown") +
                ", children=" + temp + "}";

    }
}
