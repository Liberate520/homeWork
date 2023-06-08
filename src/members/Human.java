package members;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Human implements Member, Serializable {
    private String NAME;
    private Year yearOfBirth;
    private String gender;
    private Human father;
    private Human mother;
    private List<Member> children;

    public Human(String name, String gender, int yearOfBirth) {
        this.NAME = name;
        this.yearOfBirth = Year.of(yearOfBirth);
        this.gender = gender;
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return NAME;
    }

    public Year getYearOfBirth() {
        return yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    @Override
    public void setFather(Member father) {

    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    @Override
    public void setMother(Member mother) {

    }

    @Override
    public void addChild(Member child) {

    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public List<Member> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        ArrayList<String> temp = new ArrayList<>();
        for (Member child : children) {
            temp.add(child.getName());
        }
        return "trees.Human{" +
                "Name='" + NAME + '\'' +
                ", date of brith=" + yearOfBirth +
                ", father=" + Optional.ofNullable(father).map(Human::getName).orElse("unknown") +
                ", mother=" + Optional.ofNullable(mother).map(Human::getName).orElse("unknown") +
                ", children=" + temp + "}";

    }
}
