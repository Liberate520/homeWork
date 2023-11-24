package com.ag.family_tree;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String gender;
    private int birthDate;
    private int deadDate;
    private List<Human>children;

    public Human(String name, String gender, int birthDate, int deadDate){
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deadDate = deadDate;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public String getGender() {
        return gender;
    }


    public int getBirthDate() {
        return birthDate;
    }

    public int getDeadDate() {
        return deadDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "name: " + name + ", gender: " + gender + ", birthDate: " + birthDate + ", deadDate: " + deadDate + ", children: " + children;
    }
}
