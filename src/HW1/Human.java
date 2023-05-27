package HW1;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private final String NAME;
    private Year yearOfBirth;
    private Human father;
    private Human mother;
    List<Human> children;

    public Human(String name,int yearOfBirth) {
        this.NAME = name;
        this.yearOfBirth = Year.of(yearOfBirth);
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getNAME() {
        return NAME;
    }


    @Override
    public String toString() {
        ArrayList<String> temp = new ArrayList<>();
        for (Human child : children) {
            temp.add(child.getNAME());
        }
        return "Human{" +
                "Name='" + NAME + '\'' +
                ", date of brith=" + yearOfBirth +
                ", father=" + ((father != null) ? father.getNAME() : "unknown") +
                ", mother=" + ((mother != null) ? mother.getNAME() : "unknown") +
                ", children=" + temp + "}";

    }
}
