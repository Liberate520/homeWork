package tree;

import java.util.Date;
import java.util.List;

public class Human {
    private static int global_id;
    private int id;
    private String surName;
    private String name;
    private String secondName;
    private Human father;
    private Human mother;


    public Human( String surName, String name, String secondName, Human father, Human mother) {
        id = global_id++;
        this.surName = surName;
        this.name = name;
        this.secondName = secondName;
        this.father = father;
        this.mother = mother;
    }

    public Human() {
        this("Unknown", "Unknown", "Unknown",null,null);
    }



    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", father=" + father +
                ", mother=" + mother +
                '}';
    }
}

