package model.members;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Aliens implements Member, Serializable {

    private String name;
    private String surname;
    private Year yearOfBirth;
    private Gender gender;
    private Member father;
    private Member mother;
    private List<Member> children;

    public Aliens(String NAME, String surname, Gender gender, int yearOfBirth) {
        this.name = NAME;
        this.surname = surname;
        this.yearOfBirth = Year.of(yearOfBirth);
        this.gender = gender;
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Year getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public Member getFather() {
        return father;
    }

    @Override
    public void setFather(Member father) {

    }

    @Override
    public Member getMother() {
        return mother;
    }

    @Override
    public void setMother(Member mother) {

    }

    @Override
    public void addChild(Member child) {

    }

    @Override
    public List<Member> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Aliens{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender='" + gender + '\'' +
                ", father=" + father +
                ", mother=" + mother +
                ", children=" + children +
                '}';
    }
}
