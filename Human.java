package Homework1.homeWork;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private Integer birthAge;
    private Human parent;
    private Human child;
    private List<Human> childList;

    public Human(String name, Gender gender, Integer birthAge) {
        this.name = name;
        this.gender = gender;
        this.birthAge = birthAge;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getBirthAge() {
        return birthAge;
    }

    public void SetParent(Human Parent) {
        FamilyTree.add(this.parent);
    }

    public void SetChild(Human child) {
        childList.add(this.child);
    }

    @Override
    public String toString() {
        return name + ", пол: " + gender + ", год рождения: " + birthAge;
    }

}
